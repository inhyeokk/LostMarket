package com.sejong.unknown.view.main.entity;

public class CategoryItem {

    public enum Type {
        ALL("전체", 0),
        BOOK("도서", 1),
        ETC("기타", 2);

        private String name;
        private int value;

        Type(String name, int value) {
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

    private Type type;

    public CategoryItem(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
