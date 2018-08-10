package com.market.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.domain.Profile;
import com.market.persistence.ProfileMapper;

@Service
public class ProfileServiceImpl implements ProfileService {
	@Resource ProfileMapper profileMapper;

	@Override
	public List<Profile> list(Profile profile) {
		return profileMapper.list(profile);
	}

	@Override
	public Profile select(int profileSeq) {
		return profileMapper.select(profileSeq);
	}

}
