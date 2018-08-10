package com.market.service;

import java.util.List;

import com.market.domain.Member;

public interface MemberService {
	public List<Member> list(Member member);
	public Member select(Member member);
}
