package com.sejong.unknown.view.manage.entity;

import com.sejong.unknown.view.main.entity.CategoryItem;

public class LostDetail {

    private String id;
    private CategoryItem category;
    private String image;
    private String foundDate;
    private String name;
    private String foundLocation;
    private String storageLocation;
    private String status;
    private String receiptName;
    private String receiptPhone;
    private String contents;

    public LostDetail(String id, CategoryItem category, String image, String foundDate, String name, String foundLocation, String storageLocation, String status, String receiptName, String receiptPhone, String contents) {
        this.id = id;
        this.category = category;
        this.image = image;
        this.foundDate = foundDate;
        this.name = name;
        this.foundLocation = foundLocation;
        this.storageLocation = storageLocation;
        this.status = status;
        this.receiptName = receiptName;
        this.receiptPhone = receiptPhone;
        this.contents = contents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CategoryItem getCategory() {
        return category;
    }

    public void setCategory(CategoryItem category) {
        this.category = category;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getReceiptPhone() {
        return receiptPhone;
    }

    public void setReceiptPhone(String receiptPhone) {
        this.receiptPhone = receiptPhone;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}