package com.sejong.unknown.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

abstract public class BaseActivity<VB extends ViewDataBinding> extends AppCompatActivity {

    protected int layoutRes;
    protected VB binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onDataBinding();
        setupView();
    }

    abstract protected void onDataBinding();
    abstract protected void setupView();

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
