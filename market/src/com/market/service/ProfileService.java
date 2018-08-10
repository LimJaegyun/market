package com.market.service;

import java.util.List;

import com.market.domain.Profile;

public interface ProfileService {
	public List<Profile> list(Profile profile);
	
	public Profile select(int profileSeq);
}