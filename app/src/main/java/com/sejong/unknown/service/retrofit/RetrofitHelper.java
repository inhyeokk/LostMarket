package com.sejong.unknown.service.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHelper {

    private static final long ALL_TIME_OUT = 10L;

    private static Retrofit retrofit;

    public static void init() {

        HttpLoggingInterceptor httpLogging = new HttpLoggingInterceptor();
        httpLogging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(httpLogging)
                .connectTimeout(ALL_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(ALL_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(ALL_TIME_OUT, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://interface518.dothome.co.kr/caps/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public static RetrofitService getRetrofitService(Class<RetrofitService> service) {
        return retrofit.create(service);
    }
}