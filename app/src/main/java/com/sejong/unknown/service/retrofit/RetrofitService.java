package com.sejong.unknown.service.retrofit;

import java.util.HashMap;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {

    @FormUrlEncoded
    @POST("login.php")
    Single<Response<ResponseBody>> login(@FieldMap HashMap<String, String> param);
}
