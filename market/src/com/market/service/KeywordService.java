package com.market.service;

import java.util.List;

import com.market.domain.Keyword;

public interface KeywordService {
	public List<Keyword> list(Keyword keyword);
	
	public Keyword select(Keyword keyword);
	
	public void insert(Keyword keyword);
	
	public void update(Keyword keyword);
}
