package com.demo.cartisan.models;

public class LogInfo {

	private int mId;
	private String mUserMobile;
	private String gasStationName;
	private String mFuelType;
	private String mComments;
	private double mAmount;
	private double mLiters;
	private String mLogDate;

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmUserMobile() {
		return mUserMobile;
	}

	public void setmUserMobile(String mUserMobile) {
		this.mUserMobile = mUserMobile;
	}

	public String getGasStationName() {
		return gasStationName;
	}

	public void setGasStationName(String gasStationName) {
		this.gasStationName = gasStationName;
	}

	public String getmFuelType() {
		return mFuelType;
	}

	public void setmFuelType(String mFuelType) {
		this.mFuelType = mFuelType;
	}

	public String getmComments() {
		return mComments;
	}

	public void setmComments(String mComments) {
		this.mComments = mComments;
	}

	public double getmAmount() {
		return mAmount;
	}

	public void setmAmount(double mAmount) {
		this.mAmount = mAmount;
	}

	public double getmLiters() {
		return mLiters;
	}

	public void setmLiters(double mLiters) {
		this.mLiters = mLiters;
	}

	public String getmLogDate() {
		return mLogDate;
	}

	public void setmLogDate(String mLogDate) {
		this.mLogDate = mLogDate;
	}

	@Override
	public String toString() {
		return "LogInfo [mId=" + mId + ", mUserMobile=" + mUserMobile + ", gasStationName=" + gasStationName
				+ ", mFuelType=" + mFuelType + ", mComments=" + mComments + ", mAmount=" + mAmount + ", mLiters="
				+ mLiters + ", mLogDate=" + mLogDate + "]";
	}
}
