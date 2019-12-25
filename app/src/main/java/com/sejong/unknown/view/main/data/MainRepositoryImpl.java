package com.sejong.unknown.view.main.data;

import com.sejong.unknown.view.main.domain.MainRepository;
import com.sejong.unknown.view.main.entity.CategoryItem;
import com.sejong.unknown.view.main.entity.LostItem;

import java.util.ArrayList;

import io.reactivex.Single;

public class MainRepositoryImpl implements MainRepository {

    @Override
    public Single<ArrayList<LostItem>> requestLostItems() {
        return Single.fromCallable(() -> {
            ArrayList<LostItem> items = new ArrayList<>();
            items.add(new LostItem(CategoryItem.ETC, "", "2019-12-25", "검은색 백팩", "학술정보원", "학생회관"));
            items.add(new LostItem(CategoryItem.ETC, "", "2019-12-25", "검은색 백팩", "학술정보원", "학생회관"));
            items.add(new LostItem(CategoryItem.ETC, "", "2019-12-25", "검은색 백팩", "학술정보원", "학생회관"));
            items.add(new LostItem(CategoryItem.ETC, "", "2019-12-25", "검은색 백팩", "학술정보원", "학생회관"));
            items.add(new LostItem(CategoryItem.ETC, "", "2019-12-25", "검은색 백팩", "학술정보원", "학생회관"));
            return items;
        });
    }
}
