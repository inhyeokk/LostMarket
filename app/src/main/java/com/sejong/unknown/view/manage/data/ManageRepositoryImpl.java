package com.sejong.unknown.view.manage.data;

import com.sejong.unknown.model.response.LostResponse;
import com.sejong.unknown.service.retrofit.RetrofitHelper;
import com.sejong.unknown.service.retrofit.RetrofitService;
import com.sejong.unknown.view.manage.domain.ManageRepository;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class ManageRepositoryImpl implements ManageRepository {
    @Override
    public Single<LostResponse> requestLostItemsByStatus(String stat) {
        RetrofitService service = RetrofitHelper.getRetrofitService(RetrofitService.class);
        return service.requestLostItemsByStatus(stat).subscribeOn(Schedulers.io());
    }

    @Override
    public Single<LostResponse> requestLostItemDetail(String id) {
        RetrofitService service = RetrofitHelper.getRetrofitService(RetrofitService.class);
        return service.requestLostItemDetail(id).subscribeOn(Schedulers.io());
    }
}
