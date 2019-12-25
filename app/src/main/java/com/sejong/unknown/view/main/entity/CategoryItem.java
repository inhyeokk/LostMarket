package com.sejong.unknown.view.main.entity;

public enum CategoryItem {

    ALL("전체", 0),
    BOOK("도서", 1),
    ETC("기타", 2);

    private String name;
    private int value;

    CategoryItem(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
