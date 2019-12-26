package com.sejong.unknown.view.main.entity;

public enum CategoryItem {

    ALL("전체", 0),
    BOOK("도서", 1),
    ELECTRONICS("전자기기", 2),
    PHONE("휴대폰", 3),
    CLOTHING("의류", 4),
    WALLET("지갑", 5),
    ETC("기타", 6);

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
