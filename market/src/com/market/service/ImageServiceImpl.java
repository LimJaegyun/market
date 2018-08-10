package com.market.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.market.domain.Image;
import com.market.domain.Item;
import com.market.persistence.ImageMapper;
import com.market.persistence.ItemMapper;

@Service
public class ImageServiceImpl implements ImageService {
	@Resource
	private ImageMapper imageMapper;

	@Resource
	private ItemMapper itemMapper;

	@Override
	public List<Image> list(Image image) {
		return imageMapper.list(image);
	}

	@Override
	public Image select(Image image) {
		return imageMapper.select(image);
	}

	@Override
	public void insert(List<MultipartFile> files, Item item) throws IOException {
		List<String> temp = new ArrayList<>();

		String savePath = "C:/Users/ojworld/eclipse-workspace/market/WebContent/upload/"; // 저장 경로
		if (files.size() == 1 && files.get(0).getOriginalFilename().equals("")) {
		} else {
			for (int i = 0; i < files.size(); i++) {
				Image image = new Image();

				String originalName = files.get(i).getOriginalFilename(); // 파일명

				if (!originalName.equals("")) {
					String uuidName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(originalName);
					String path = savePath + uuidName;

					image.setOriginalName(originalName);
					image.setRandomName(uuidName);

					imageMapper.insert(image);

					temp.add(String.valueOf("/" + image.getImageSeq()));

					long time = System.currentTimeMillis();
					SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String str = dayTime.format(new Date(time));

					item.setDate(str);

					System.out.println(item.toString());

					File dir = new File(savePath);
					if (!dir.isDirectory()) {
						dir.mkdirs();
					}
					files.get(i).transferTo(new File(path));
				}
			}
		}

//		String combine = "";
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < temp.size(); i++) {
			sb.append(temp.get(i).toString());
//			combine = combine + temp.get(i).toString();
		}

		item.setImage(sb.toString());
		itemMapper.insert(item);
	}

	@Override
	public void delete(Image image) {
		File file = new File(image.getRandomName());

		file.delete();

		imageMapper.delete(image.getImageSeq());
	}
}