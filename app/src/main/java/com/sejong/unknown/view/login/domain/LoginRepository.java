package com.sejong.unknown.view.login.domain;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Response;

public interface LoginRepository {
    Single<Response<ResponseBody>> login(String id, String pw);
}
