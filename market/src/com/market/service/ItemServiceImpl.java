package com.market.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.domain.Item;
import com.market.persistence.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService {
	@Resource
	private ItemMapper ItemMapper;

	@Override
	public List<Item> list(Item item) {
		return ItemMapper.list(item);
	}

	@Override
	public Item select(Item item) {
		return ItemMapper.select(item);
	}
	
	@Override
	public void insert(Item item) {
		ItemMapper.insert(item);
	}

	@Override
	public void delete(int itemSeq) {
		ItemMapper.delete(itemSeq);
	}
}