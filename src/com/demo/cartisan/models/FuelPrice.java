package com.demo.cartisan.models;

public class FuelPrice {

	private int mId;
	private String mCurrentDate;
	private String mCity;
	private double mCurPetrolPrice;
	private double mCurDieselPrice;
	private double mPrvPetrolPrice;
	private double mPrvDieselPrice;

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmCurrentDate() {
		return mCurrentDate;
	}

	public void setmCurrentDate(String mCurrentDate) {
		this.mCurrentDate = mCurrentDate;
	}

	public String getmCity() {
		return mCity;
	}

	public void setmCity(String mCity) {
		this.mCity = mCity;
	}

	public double getmCurPetrolPrice() {
		return mCurPetrolPrice;
	}

	public void setmCurPetrolPrice(double mCurPetrolPrice) {
		this.mCurPetrolPrice = mCurPetrolPrice;
	}

	public double getmCurDieselPrice() {
		return mCurDieselPrice;
	}

	public void setmCurDieselPrice(double mCurDieselPrice) {
		this.mCurDieselPrice = mCurDieselPrice;
	}

	public double getmPrvPetrolPrice() {
		return mPrvPetrolPrice;
	}

	public void setmPrvPetrolPrice(double mPrvPetrolPrice) {
		this.mPrvPetrolPrice = mPrvPetrolPrice;
	}

	public double getmPrvDieselPrice() {
		return mPrvDieselPrice;
	}

	public void setmPrvDieselPrice(double mPrvDieselPrice) {
		this.mPrvDieselPrice = mPrvDieselPrice;
	}

	@Override
	public String toString() {
		return "FuelPrice [mId=" + mId + ", mCurrentDate=" + mCurrentDate + ", mCity=" + mCity + ", mCurPetrolPrice="
				+ mCurPetrolPrice + ", mCurDieselPrice=" + mCurDieselPrice + ", mPrvPetrolPrice=" + mPrvPetrolPrice
				+ ", mPrvDieselPrice=" + mPrvDieselPrice + "]";
	}

}
