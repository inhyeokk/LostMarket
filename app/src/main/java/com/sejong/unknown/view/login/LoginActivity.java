package com.sejong.unknown.view.login;

import android.content.Intent;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.jakewharton.rxbinding3.widget.RxTextView;
import com.sejong.unknown.R;
import com.sejong.unknown.base.BaseActivity;
import com.sejong.unknown.databinding.ActivityLoginBinding;
import com.sejong.unknown.view.login.data.LoginRepositoryImpl;
import com.sejong.unknown.view.main.data.ContextDelegateImpl;
import com.sejong.unknown.view.manage.ManageActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel = new LoginViewModel(new ContextDelegateImpl(this), new LoginRepositoryImpl());

    @Override
    protected void onDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewModel(loginViewModel);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void setupView() {
        initEditText();
        observeLoginViewModel();
    }

    private void initEditText() {
        loginViewModel.register(
                RxTextView.textChanges(binding.edId).subscribe(id ->
                        loginViewModel.onUpdateId(id.toString())
                ),
                RxTextView.textChanges(binding.edPassword).subscribe(password ->
                        loginViewModel.onUpdatePassword(password.toString())
                )
        );
    }

    private void observeLoginViewModel() {
        loginViewModel.showMessageEvent.observe(this, this::showToast);
        loginViewModel.loginSuccessEvent.observe(this, success -> goToManageActivity());
    }

    private void goToManageActivity() {
        Intent intent = new Intent(this, ManageActivity.class);
        startActivity(intent);
    }
}
