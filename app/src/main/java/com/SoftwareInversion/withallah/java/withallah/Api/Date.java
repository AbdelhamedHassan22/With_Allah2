package com.SoftwareInversion.withallah.java.withallah.Api;

import com.google.gson.annotations.SerializedName;

public class Date{

    @SerializedName("hijri")
    private String hijri;

    @SerializedName("gregorian")
    private String gregorian;

    @SerializedName("timestamp")
    private int timestamp;

    public String getHijri(){
        return hijri;
    }

    public String getGregorian(){
        return gregorian;
    }

    public int getTimestamp(){
        return timestamp;
    }
}