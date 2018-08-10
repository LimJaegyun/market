package com.market.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.domain.Member;
import com.market.persistence.MemberMapper;	

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberMapper memberMapper;
	
	@Override
	public List<Member> list(Member member) {
		List<Member> list = memberMapper.list(member);
		return memberMapper.list(member);
	}

	@Override
	public Member select(Member member) {
		return memberMapper.select(member);
	}

}
