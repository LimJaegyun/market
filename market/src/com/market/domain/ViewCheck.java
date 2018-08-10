package com.market.domain;

import java.io.Serializable;

public class ViewCheck implements Serializable {
	private int viewSeq;
	private int memberSeq;
	private int keywordSeq;
	private String viewDate;

	public ViewCheck() {
	}

	public ViewCheck(int viewSeq, int memberSeq, int keywordSeq, String viewDate) {
		this.viewSeq = viewSeq;
		this.memberSeq = memberSeq;
		this.keywordSeq = keywordSeq;
		this.viewDate = viewDate;
	}

	public int getViewSeq() {
		return viewSeq;
	}

	public void setViewSeq(int viewSeq) {
		this.viewSeq = viewSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public int getkeywordSeq() {
		return keywordSeq;
	}

	public void setkeywordSeq(int keywordSeq) {
		this.keywordSeq = keywordSeq;
	}

	public String getViewDate() {
		return viewDate;
	}

	public void setViewDate(String viewDate) {
		this.viewDate = viewDate;
	}

	@Override
	public String toString() {
		return "ViewCheck [viewSeq=" + viewSeq + ", memberSeq=" + memberSeq + ", keywordSeq=" + keywordSeq + ", viewDate="
				+ viewDate + "]";
	}
}
