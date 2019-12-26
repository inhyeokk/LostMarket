package com.sejong.unknown.service.retrofit;

import com.sejong.unknown.model.response.LostResponse;

import java.util.HashMap;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {

    @FormUrlEncoded
    @POST("login.php")
    Single<Response<ResponseBody>> login(@FieldMap HashMap<String, String> param);

    @GET("lost_fillter.php")
    Single<LostResponse> requestLostItems(@Query("tag") String tag);

    @GET("lost_admin_stat.php")
    Single<LostResponse> requestLostItemsByStatus(@Query("stat") String stat);
}
