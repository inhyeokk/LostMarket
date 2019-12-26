package com.sejong.unknown.view.login;

import android.util.Log;

import com.sejong.unknown.base.BaseViewModel;
import com.sejong.unknown.view.login.domain.LoginRepository;

import java.io.IOException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class LoginViewModel extends BaseViewModel {

    private static final String TAG = LoginViewModel.class.getName();

    private LoginRepository loginRepository;

    public void requestLogin() {
        register((loginRepository.login())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleTestResponse, this::handleError)
        );
    }

    private void handleTestResponse(Response<ResponseBody> result) {
        try {
            Log.d(TAG, result.body().string());
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    private void handleError(Throwable throwable) {
        Log.e(TAG, throwable.getMessage());
    }
}
