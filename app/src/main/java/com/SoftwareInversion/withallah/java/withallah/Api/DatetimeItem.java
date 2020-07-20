package com.SoftwareInversion.withallah.java.withallah.Api;

import com.google.gson.annotations.SerializedName;

public class DatetimeItem{

    @SerializedName("date")
    private Date date;

    @SerializedName("times")
    private Times times;

    public Date getDate(){
        return date;
    }

    public Times getTimes(){
        return times;
    }
}