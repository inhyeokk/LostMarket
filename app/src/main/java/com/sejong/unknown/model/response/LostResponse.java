package com.sejong.unknown.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LostResponse {

    @SerializedName("result")
    public ArrayList<Lost> lostList;
}
