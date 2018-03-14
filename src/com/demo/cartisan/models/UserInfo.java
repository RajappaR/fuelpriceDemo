package com.demo.cartisan.models;

public class UserInfo {

	private String mMobile;
	private String mName;
	private String mEmail;

	public String getmMobile() {
		return mMobile;
	}

	public void setmMobile(String mMobile) {
		this.mMobile = mMobile;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	@Override
	public String toString() {
		return "UserInfo [mMobile=" + mMobile + ", mName=" + mName + ", mEmail=" + mEmail + "]";
	}

}
