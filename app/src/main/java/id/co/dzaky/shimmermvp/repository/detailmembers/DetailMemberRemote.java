package id.co.dzaky.shimmermvp.repository.detailmembers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import id.co.dzaky.shimmermvp.api.ApiClient;
import id.co.dzaky.shimmermvp.api.ApiInterface;
import id.co.dzaky.shimmermvp.model.detail.DetailItem;
import id.co.dzaky.shimmermvp.model.detail.ResponseDetailMember;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMemberRemote implements DetailMemberDataResource {
    Context context;
    ApiInterface apiInterface;

    public DetailMemberRemote(Context context) {
        this.context = context;
    }

    @Override
    public void getData(int id, @NonNull final DataCallback dataCallback) {
        apiInterface = ApiClient.getInstance();
        final Call<ResponseDetailMember> detailMemberCall = apiInterface.getDetailMember(id);
        detailMemberCall.enqueue(new Callback<ResponseDetailMember>() {
            @Override
            public void onResponse(Call<ResponseDetailMember> call, Response<ResponseDetailMember> response) {
                try {
                    if (response.isSuccessful()) {
                        ResponseDetailMember responseDetailMember = response.body();
                        List<DetailItem> detailItems = responseDetailMember.getDetail();
                        String surname = detailItems.get(0).getSurname();
                        String nickname = detailItems.get(0).getNickname();
                        String birthday = detailItems.get(0).getBirthday();
                        String blood = detailItems.get(0).getBloodType();
                        String horoskop = detailItems.get(0).getHoroskop();
                        String height = detailItems.get(0).getHeight();
                        String twitterLink = detailItems.get(0).getTwitterLink();
                        String igLink = detailItems.get(0).getInstagramLink();
                        String vlink = detailItems.get(0).getVideoLink();
                        Log.i("Response Detail ", String.valueOf(detailItems.toString()));
                        dataCallback.onSucces(surname, nickname, birthday, blood, horoskop, height, twitterLink, igLink, vlink, "Success");
                    }

                } catch (Exception e) {
                    dataCallback.onError("Null");
                }
            }

            @Override
            public void onFailure(Call<ResponseDetailMember> call, Throwable t) {
                dataCallback.onError("No internet connection");
            }
        });
    }
}
