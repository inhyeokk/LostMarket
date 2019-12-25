package com.sejong.unknown.view.main;

import androidx.lifecycle.MutableLiveData;

import com.sejong.unknown.base.BaseViewModel;
import com.sejong.unknown.view.main.entity.CategoryItem;

public class MainViewModel extends BaseViewModel {

    private static final String TAG = MainViewModel.class.getName();

    public MutableLiveData<CategoryItem> categoryItemLiveData = new MutableLiveData<>();

    public void onClickCategoryItem(CategoryItem categoryItem) {
        categoryItemLiveData.setValue(categoryItem);
    }
}
