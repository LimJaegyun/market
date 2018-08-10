package com.market.domain;

import java.io.Serializable;

public class Image implements Serializable {
	private int imageSeq;
	private String originalName;
	private String randomName;
	
	public Image() {
		
	}
	
	public Image(int imageSeq, String originalName, String randomName) {
		this.imageSeq = imageSeq;
		this.originalName = originalName;
		this.randomName = randomName;
	}
	
	public int getImageSeq() {
		return imageSeq;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setImageSeq(int imageSeq) {
		this.imageSeq = imageSeq;
	}
	
	public String getRandomName() {
		return randomName;
	}

	public void setRandomName(String randomName) {
		this.randomName = randomName;
	}

	@Override
	public String toString() {
		return "Image [imageSeq=" + imageSeq + ", originalName=" + originalName + ", randomName=" + randomName + "]";
	}
}
