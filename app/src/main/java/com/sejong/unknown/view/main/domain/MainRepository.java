package com.sejong.unknown.view.main.domain;

import com.sejong.unknown.model.response.LostResponse;

import io.reactivex.Single;

public interface MainRepository {
    Single<LostResponse> requestLostItems(String tag);
}
