package com.SoftwareInversion.withallah.java.withallah.Api;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("code")
	private int code;

	@SerializedName("results")
	private Results results;

	@SerializedName("status")
	private String status;

	public int getCode(){
		return code;
	}

  public Results getResults(){
		return results;
  }
	public String getStatus(){
		return status;
	}
}