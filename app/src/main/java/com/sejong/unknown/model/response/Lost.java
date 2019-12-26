package com.sejong.unknown.model.response;

import com.google.gson.annotations.SerializedName;

public class Lost {
    @SerializedName("lostid") public String id;
    @SerializedName("lostimage") public String image;
    @SerializedName("getdate") public String foundDate;
    @SerializedName("getplace") public String foundLocation;
    @SerializedName("storeplace") public String storageLocation;
    @SerializedName("tagname") public String category;
    @SerializedName("detailname") public String detailName;
    @SerializedName("detail") public String detail;
}
