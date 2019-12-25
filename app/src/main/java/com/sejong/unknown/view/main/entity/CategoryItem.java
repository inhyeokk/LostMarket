package com.sejong.unknown.view.main.entity;

public class CategoryItem {

    public enum Type {
        ALL("전체"),
        BOOK("도서"),
        ETC("기타");

        private String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
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
