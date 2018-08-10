package com.market.domain;

import java.io.Serializable;

public class Keyword implements Serializable {
	private int keywordSeq;
	private String keyword;
	private int look;
	private int memberSeq;
	
	public Keyword() {

	}

	public Keyword(int keywordSeq, String keyword, int look, int memberSeq) {
		this.keywordSeq = keywordSeq;
		this.keyword = keyword;
		this.look = look;
		this.memberSeq = memberSeq;
	}

	
	
	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public int getKeywordSeq() {
		return keywordSeq;
	}

	public void setKeywordSeq(int keywordSeq) {
		this.keywordSeq = keywordSeq;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getLook() {
		return look;
	}

	public void setLook(int look) {
		this.look = look;
	}

	@Override
	public String toString() {
		return "Keyword [keywordSeq=" + keywordSeq + ", keyword=" + keyword + ", look=" + look + "]";
	}
}