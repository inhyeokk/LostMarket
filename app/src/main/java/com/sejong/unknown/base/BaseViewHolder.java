package com.sejong.unknown.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

abstract public class BaseViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {

    protected B binding;

    public BaseViewHolder(@NonNull View itemView, @LayoutRes int layoutResId, ViewGroup parent) {
        super(itemView);
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutResId, parent, false);
    }
}
