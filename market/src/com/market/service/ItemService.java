package com.market.service;

import java.util.List;

import com.market.domain.Item;

public interface ItemService {
	public List<Item> list(Item item);
	
	public Item select(Item item);
	
	public void insert(Item item);
	
	public void delete(int itemSeq);
}
