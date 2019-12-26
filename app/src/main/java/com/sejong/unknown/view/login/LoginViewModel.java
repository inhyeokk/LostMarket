package com.sejong.unknown.view.login;

import android.util.Log;

import androidx.annotation.StringRes;
import androidx.lifecycle.MutableLiveData;

import com.sejong.unknown.R;
import com.sejong.unknown.base.BaseViewModel;
import com.sejong.unknown.view.login.domain.LoginRepository;
import com.sejong.unknown.view.main.domain.ContextDelegate;

import java.io.IOException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class LoginViewModel extends BaseViewModel {

    private static final String TAG = LoginViewModel.class.getName();

    public MutableLiveData<String> id = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<Boolean> loginClickable = new MutableLiveData<>();

    public MutableLiveData<String> showMessageEvent = new MutableLiveData<>();
    public MutableLiveData<Boolean> loginSuccessEvent = new MutableLiveData<>();

    private ContextDelegate contextDelegate;
    private LoginRepository loginRepository;

    public LoginViewModel(ContextDelegate contextDelegate, LoginRepository loginRepository) {
        this.contextDelegate = contextDelegate;
        this.loginRepository = loginRepository;
        onUpdateId("");
        onUpdatePassword("");
    }

    public void onUpdateId(String value) {
        id.setValue(value);
    }

    public void onUpdatePassword(String value) {
        password.setValue(value);
    }

    private void onUpdateShowMessage(@StringRes int stringResId) {
        showMessageEvent.setValue(contextDelegate.getString(stringResId));
    }

    public void requestLogin() {
        register((loginRepository.login(id.getValue(), password.getValue()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleLoginResponse, this::handleError)
        );
    }

    private void handleLoginResponse(Response<ResponseBody> result) {
        try {
            if (result.body().string().equals("OK2")) {
                loginSuccessEvent.setValue(true);
            } else {
                onUpdateShowMessage(R.string.login_toast_notice);
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    private void handleError(Throwable throwable) {
        Log.e(TAG, throwable.getMessage());
    }
}
