package com.sejong.unknown.view.main.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.sejong.unknown.R;

public class LostBindingAdapter {

    private static Resources resources;

    public static void init(Context context) {
        resources = context.getResources();
    }

    @BindingAdapter("bind_found_date")
    public static void setFoundDate(TextView textView, String foundDate) {
        textView.setText(resources.getString(R.string.lost_tv_found_date, foundDate));
    }

    @BindingAdapter("bind_found_location")
    public static void setFoundLocation(TextView textView, String foundLocation) {
        textView.setText(resources.getString(R.string.lost_tv_found_location, foundLocation));
    }

    @BindingAdapter("bind_storage_location")
    public static void setStorageLocation(TextView textView, String storageLocation) {
        textView.setText(resources.getString(R.string.lost_tv_storage_location, storageLocation));
    }
}
