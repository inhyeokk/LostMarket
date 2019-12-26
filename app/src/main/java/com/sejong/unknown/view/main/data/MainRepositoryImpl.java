package com.sejong.unknown.view.main.data;

import com.sejong.unknown.model.response.LostResponse;
import com.sejong.unknown.service.retrofit.RetrofitHelper;
import com.sejong.unknown.service.retrofit.RetrofitService;
import com.sejong.unknown.view.main.domain.MainRepository;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class MainRepositoryImpl implements MainRepository {

    @Override
    public Single<LostResponse> requestLostItems(String tag) {
        RetrofitService service = RetrofitHelper.getRetrofitService(RetrofitService.class);
        return service.requestLostItems(tag).subscribeOn(Schedulers.io());
    }
}
