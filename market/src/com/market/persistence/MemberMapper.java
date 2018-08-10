package com.market.persistence;

import java.util.List;

import com.market.domain.Member;

public interface MemberMapper {
	public List<Member> list(Member member);
	public Member select(Member member);
}
