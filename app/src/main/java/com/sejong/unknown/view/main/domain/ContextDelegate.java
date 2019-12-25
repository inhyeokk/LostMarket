package com.sejong.unknown.view.main.domain;

import androidx.annotation.StringRes;

public interface ContextDelegate {
    String getString(@StringRes int stringResId);
    String getString(@StringRes int stringResId, Object... formatArgs);
}
