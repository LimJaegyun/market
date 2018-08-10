package com.market.domain;

import java.io.Serializable;

public class Profile implements Serializable {
	private int profileSeq;
	private String originalName;
	private String randomName;

	public Profile() {

	}

	public Profile(int profileSeq, String originalName, String randomName) {
		this.profileSeq = profileSeq;
		this.originalName = originalName;
		this.randomName = randomName;
	}

	public int getProfileSeq() {
		return profileSeq;
	}

	public void setProfileSeq(int profileSeq) {
		this.profileSeq = profileSeq;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getRandomName() {
		return randomName;
	}

	public void setRandomName(String randomName) {
		this.randomName = randomName;
	}

	@Override
	public String toString() {
		return "Profile [profileSeq=" + profileSeq + ", originalName=" + originalName + ", randomName=" + randomName
				+ "]";
	}
}