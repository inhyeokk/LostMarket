package com.sejong.unknown.view.main.entity;

public class LostItem {

    private CategoryItem type;
    private String image;
    private String foundDate;
    private String name;
    private String foundLocation;
    private String storageLocation;

    public LostItem(CategoryItem type, String image, String foundDate, String name, String foundLocation, String storageLocation) {
        this.type = type;
        this.image = image;
        this.foundDate = foundDate;
        this.name = name;
        this.foundLocation = foundLocation;
        this.storageLocation = storageLocation;
    }

    public CategoryItem getType() {
        return type;
    }

    public void setType(CategoryItem type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoundLocation() {
        return foundLocation;
    }

    public void setFoundLocation(String foundLocation) {
        this.foundLocation = foundLocation;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }
}
