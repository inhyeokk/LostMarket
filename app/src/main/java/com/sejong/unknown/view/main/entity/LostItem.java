package com.sejong.unknown.view.main.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class LostItem implements Parcelable {

    private String id;
    private CategoryItem type;
    private String image;
    private String foundDate;
    private String name;
    private String foundLocation;
    private String storageLocation;
    private String contents;

    public LostItem(String id, CategoryItem type, String image, String foundDate, String name, String foundLocation, String storageLocation, String contents) {
        this.id = id;
        this.type = type;
        this.image = image;
        this.foundDate = foundDate;
        this.name = name;
        this.foundLocation = foundLocation;
        this.storageLocation = storageLocation;
        this.contents = contents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeInt(this.type == null ? -1 : this.type.ordinal());
        dest.writeString(this.image);
        dest.writeString(this.foundDate);
        dest.writeString(this.name);
        dest.writeString(this.foundLocation);
        dest.writeString(this.storageLocation);
        dest.writeString(this.contents);
    }

    protected LostItem(Parcel in) {
        this.id = in.readString();
        int tmpType = in.readInt();
        this.type = tmpType == -1 ? null : CategoryItem.values()[tmpType];
        this.image = in.readString();
        this.foundDate = in.readString();
        this.name = in.readString();
        this.foundLocation = in.readString();
        this.storageLocation = in.readString();
        this.contents = in.readString();
    }

    public static final Creator<LostItem> CREATOR = new Creator<LostItem>() {
        @Override
        public LostItem createFromParcel(Parcel source) {
            return new LostItem(source);
        }

        @Override
        public LostItem[] newArray(int size) {
            return new LostItem[size];
        }
    };
}
