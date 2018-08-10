package com.market.domain;

import java.io.Serializable;

public class Member implements Serializable {
	private int memberSeq;
	private String id;
	private String password;
	private String nick;
	private int profileSeq;
	private int saleItem;
	private int saleCount;
	private int visit;
	private int store;

	public Member() {

	}

	public Member(int memberSeq, String id, String password, String nick, int profileSeq, int saleItem, int saleCount,
			int visit, int store) {
		this.memberSeq = memberSeq;
		this.id = id;
		this.password = password;
		this.nick = nick;
		this.profileSeq = profileSeq;
		this.saleItem = saleItem;
		this.saleCount = saleCount;
		this.visit = visit;
		this.store = store;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getProfileSeq() {
		return profileSeq;
	}

	public void setProfileSeq(int profileSeq) {
		this.profileSeq = profileSeq;
	}

	public int getSaleItem() {
		return saleItem;
	}

	public void setSaleItem(int saleItem) {
		this.saleItem = saleItem;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public int getVisit() {
		return visit;
	}

	public void setVisit(int visit) {
		this.visit = visit;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	@Override
	public String toString() {
		return "Member [memberSeq=" + memberSeq + ", id=" + id + ", password=" + password + ", nick=" + nick
				+ ", profileSeq=" + profileSeq + ", saleItem=" + saleItem + ", saleCount=" + saleCount + ", visit=" + visit
				+ ", store=" + store + "]";
	}
}
