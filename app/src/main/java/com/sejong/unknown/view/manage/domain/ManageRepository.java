package com.sejong.unknown.view.manage.domain;

import com.sejong.unknown.model.response.LostResponse;

import io.reactivex.Single;

public interface ManageRepository {
    Single<LostResponse> requestLostItemsByStatus(String tag);
    Single<LostResponse> requestLostItemDetail(String id);
}
