package com.sejong.unknown.view.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.sejong.unknown.R;
import com.sejong.unknown.base.BaseViewModel;
import com.sejong.unknown.model.response.Lost;
import com.sejong.unknown.model.response.LostResponse;
import com.sejong.unknown.view.main.domain.ContextDelegate;
import com.sejong.unknown.view.main.domain.MainRepository;
import com.sejong.unknown.view.main.entity.CategoryItem;
import com.sejong.unknown.view.main.entity.LostItem;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel {

    private static final String TAG = MainViewModel.class.getName();

    private MainRepository mainRepository;

    public MutableLiveData<ArrayList<LostItem>> lostItemsLiveData = new MutableLiveData<>();

    public MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public MutableLiveData<CategoryItem> categoryItemLiveData = new MutableLiveData<>();
    public MutableLiveData<LostItem> lostItemLiveData = new MutableLiveData<>();

    public void onClickCategoryItem(CategoryItem categoryItem) {
        categoryItemLiveData.setValue(categoryItem);
    }

    public void onClickLostItem(LostItem lostItem) {
        lostItemLiveData.setValue(lostItem);
    }

    public void requestLostItems(String category) {
        if (category.equals(CategoryItem.ALL.getName())) {
            category = "";
        }
        register(mainRepository.requestLostItems(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleLostItemsResponse, this::handleError));
    }

    private void handleLostItemsResponse(LostResponse response) {
        ArrayList<LostItem> lostItemList = new ArrayList<>();
        for (Lost lost: response.lostList) {
            LostItem item = new LostItem(
                    lost.id,
                    CategoryItem.fromString(lost.category),
                    lost.image,
                    lost.foundDate,
                    lost.detailName,
                    lost.foundLocation,
                    lost.storageLocation,
                    lost.detail
            );
            lostItemList.add(item);
        }
        lostItemsLiveData.setValue(lostItemList);
    }

    private void handleError(Throwable throwable) {
        Log.e(TAG, throwable.getMessage());
    }
}
