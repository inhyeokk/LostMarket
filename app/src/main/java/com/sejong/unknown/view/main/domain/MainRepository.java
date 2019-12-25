package com.sejong.unknown.view.main.domain;

import com.sejong.unknown.view.main.entity.LostItem;

import java.util.ArrayList;

import io.reactivex.Single;

public interface MainRepository {
    Single<ArrayList<LostItem>> requestLostItems();
}
