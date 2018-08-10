package com.market.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.domain.Keyword;
import com.market.persistence.KeywordMapper;

@Service
public class KeywordServiceImpl implements KeywordService {
	@Resource
	private KeywordMapper keywordMapper;

	@Override
	public List<Keyword> list(Keyword keyword) {
		return keywordMapper.list(keyword);
	}

	@Override
	public Keyword select(Keyword keyword) {
		return keywordMapper.select(keyword);
	}

	@Override
	public void insert(Keyword keyword) {
		String[] tag = keyword.getKeyword().split("#");
		
		for(int i = 0 ; i < tag.length ; i++) {
			Keyword temp = new Keyword();
			keyword = new Keyword();
			temp.setKeyword("#" + tag[i]);
			temp = keywordMapper.select(temp);
			
			if(tag[i].length() != 0) {
				if(temp == null) {
					keyword.setKeyword("#" + tag[i]);
					keyword.setLook(0);
					keywordMapper.insert(keyword);
				} 
			}
		}
	}

	@Override
	public void update(Keyword keyword) {
		keywordMapper.update(keyword);
	}
}