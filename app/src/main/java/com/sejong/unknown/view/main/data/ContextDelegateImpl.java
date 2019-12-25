package com.sejong.unknown.view.main.data;

import android.content.Context;

import com.sejong.unknown.view.main.domain.ContextDelegate;

public class ContextDelegateImpl implements ContextDelegate {

    private Context context;

    public ContextDelegateImpl(Context context) {
        this.context = context;
    }

    @Override
    public String getString(int stringResId) {
        return context.getString(stringResId);
    }

    @Override
    public String getString(int stringResId, Object... formatArgs) {
        return context.getString(stringResId, formatArgs);
    }
}
