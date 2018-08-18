package id.co.dzaky.shimmermvp.repository.members.teamt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import id.co.dzaky.shimmermvp.api.ApiClient;
import id.co.dzaky.shimmermvp.api.ApiInterface;
import id.co.dzaky.shimmermvp.model.member.ResponseMember;
import id.co.dzaky.shimmermvp.model.member.TeamKiiiItem;
import id.co.dzaky.shimmermvp.model.member.TeamTItem;
import id.co.dzaky.shimmermvp.repository.members.teamkiii.KiiiDataResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TDataRemote implements TDataResource {
    Context context;
    ApiInterface apiInterface;

    public TDataRemote(Context context) {
        this.context = context;
    }

    @Override
    public void getData(@NonNull final TDataResource.DataCallback dataCallback) {
        apiInterface = ApiClient.getInstance();
        final Call<ResponseMember> responseMemberCall = apiInterface.getMember();
        responseMemberCall.enqueue(new Callback<ResponseMember>() {
            @Override
            public void onResponse(Call<ResponseMember> call, Response<ResponseMember> response) {
                try {
                    if (response.isSuccessful()) {
                        ResponseMember member = response.body();
                        List<TeamTItem> teamTItems = member.getTeamT();
                        Log.i("Response Team J ", String.valueOf(teamTItems.toString()));
                        dataCallback.onSucces(teamTItems, "Success");
                    } else {
                        dataCallback.onError("Null");
                    }
                } catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<ResponseMember> call, Throwable t) {
                dataCallback.onError("No internet connection");
            }
        });
    }
}