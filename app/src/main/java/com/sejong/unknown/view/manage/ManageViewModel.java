package com.sejong.unknown.view.manage;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.sejong.unknown.base.BaseViewModel;
import com.sejong.unknown.model.response.Lost;
import com.sejong.unknown.model.response.LostResponse;
import com.sejong.unknown.view.main.entity.CategoryItem;
import com.sejong.unknown.view.main.entity.LostItem;
import com.sejong.unknown.view.manage.domain.ManageRepository;
import com.sejong.unknown.view.manage.entity.LostDetail;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ManageViewModel extends BaseViewModel {

    private static final String TAG = ManageViewModel.class.getName();

    private ManageRepository manageRepository;

    public MutableLiveData<ArrayList<LostItem>> lostLiveData = new MutableLiveData<>();
    public MutableLiveData<ArrayList<LostItem>> pickUpLiveData = new MutableLiveData<>();
    public MutableLiveData<ArrayList<LostItem>> notRentalLiveData = new MutableLiveData<>();
    public MutableLiveData<ArrayList<LostItem>> rentalLiveData = new MutableLiveData<>();

    public MutableLiveData<LostDetail> lostDetailLiveData = new MutableLiveData<>();

    public ManageViewModel(ManageRepository manageRepository) {
        this.manageRepository = manageRepository;
    }

    public void onClickLostItem(LostItem lostItem) {
        requestLostDetail(lostItem.getId());
    }

    public void requestLostItems(String status) {
        register(manageRepository.requestLostItemsByStatus(status)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> handleLostItemsResponse(status, response), this::handleError));
    }

    private void handleLostItemsResponse(String status, LostResponse response) {
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
        switch (status) {
            case "0":
                lostLiveData.setValue(lostItemList);
                break;
            case "1":
                pickUpLiveData.setValue(lostItemList);
                break;
            case "2":
                notRentalLiveData.setValue(lostItemList);
                break;
            case "3":
                rentalLiveData.setValue(lostItemList);
                break;
        }
    }

    public void requestLostDetail(String id) {
        register(manageRepository.requestLostItemDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleLostDetailResponse, this::handleError));
    }

    private void handleLostDetailResponse(LostResponse response) {
        Lost lost = response.lostList.get(0);
        LostDetail lostDetail = new LostDetail(
                lost.id,
                CategoryItem.fromString(lost.category),
                lost.image,
                lost.foundDate,
                lost.detailName,
                lost.foundLocation,
                lost.storageLocation,
                lost.status,
                lost.receiptName,
                lost.receiptPhone,
                lost.detail
        );
        lostDetailLiveData.setValue(lostDetail);
    }

    private void handleError(Throwable throwable) {
        Log.e(TAG, throwable.getMessage());
    }
}
