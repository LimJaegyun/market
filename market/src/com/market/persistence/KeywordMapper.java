package com.market.persistence;

import java.util.List;

import com.market.domain.Keyword;

public interface KeywordMapper {
	public List<Keyword> list(Keyword keyword);
	
	public Keyword select(Keyword keyword);
	
	public void insert(Keyword keyword);
	
	public void update(Keyword keyword);
}
