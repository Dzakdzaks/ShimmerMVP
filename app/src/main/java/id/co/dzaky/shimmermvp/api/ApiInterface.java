package id.co.dzaky.shimmermvp.api;

import id.co.dzaky.shimmermvp.model.detail.ResponseDetailMember;
import id.co.dzaky.shimmermvp.model.member.ResponseMember;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("index.php")
    Call<ResponseMember> getMember();

    @GET("index.php")
    Call<ResponseDetailMember> getDetailMember(
            @Query("id") int id
    );
}
