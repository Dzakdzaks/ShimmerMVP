package id.co.dzaky.shimmermvp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit getRetrofit(){

        return new Retrofit.Builder()
                .baseUrl("http://192.168.10.147/jeketi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiInterface getInstance() {
        return getRetrofit().create(ApiInterface.class);
    }
}
