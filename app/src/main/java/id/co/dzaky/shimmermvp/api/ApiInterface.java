package id.co.dzaky.shimmermvp.api;

import id.co.dzaky.shimmermvp.model.member.ResponseMember;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("index.php")
    Call<ResponseMember> getMember();
}
