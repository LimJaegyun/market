package com.market.persistence;

import java.util.List;

import com.market.domain.Profile;

public interface ProfileMapper {
	public List<Profile> list(Profile profile);
	
	public Profile select(int profileSeq);
}
