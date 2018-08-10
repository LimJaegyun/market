package com.market.persistence;

import java.util.List;

import com.market.domain.Image;

public interface ImageMapper {
	public List<Image> list(Image image);
	
	public Image select(Image image);
	
	public int insert(Image image);
	
	public void delete(int imageSeq);
}
