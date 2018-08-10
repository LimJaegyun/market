package com.market.domain;

import java.io.Serializable;

public class Item implements Serializable {
	private int itemSeq;
	private String name;
	private int memberSeq;
	private int price;
	private int count;
	private String title;
	private String image;
	private String tag;
	private String detail;
	private String date;

	public Item() {

	}

	public Item(int itemSeq, String name, int memberSeq, int price, int count, String title, String image,
			String tag, String detail, String date) {
		this.itemSeq = itemSeq;
		this.name = name;
		this.memberSeq = memberSeq;
		this.price = price;
		this.count = count;
		this.title = title;
		this.image = image;
		this.tag = tag;
		this.detail = detail;
		this.date = date;
	}

	public int getItemSeq() {
		return itemSeq;
	}

	public void setItemSeq(int itemSeq) {
		this.itemSeq = itemSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Item [itemSeq=" + itemSeq + ", name=" + name + ", memberSeq=" + memberSeq + ", price=" + price
				+ ", count=" + count + ", title=" + title + ", image=" + image + ", tag=" + tag + ", detail="
				+ detail + ", date=" + date + "]";
	}
}
