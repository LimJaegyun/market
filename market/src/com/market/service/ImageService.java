package com.market.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.market.domain.Image;
import com.market.domain.Item;

public interface ImageService {
	public List<Image> list(Image image);
	
	public Image select(Image image);
	
	public void insert(List<MultipartFile> files, Item item) throws IOException;
	
	public void delete(Image image);
}
