package com.market.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.market.domain.Image;
import com.market.domain.Item;
import com.market.domain.Keyword;
import com.market.service.ImageService;
import com.market.service.ItemService;
import com.market.service.KeywordService;
import com.market.service.MemberService;

@Controller
@RequestMapping("/main")
public class ItemContoller {
	@Autowired
	private MemberService memberService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private KeywordService keywordService;
	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addForm() {
		ModelAndView modelAndView = new ModelAndView("/add");
		return modelAndView;

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(MultipartHttpServletRequest request, Item item) throws IOException {
		List<MultipartFile> files = request.getFiles("files");

		System.out.println(files.size());
		HttpSession session = request.getSession();

		imageService.insert(files, item);

		Keyword keyword = new Keyword();
		keyword.setKeyword(item.getTag());
		keywordService.insert(keyword);

		System.out.println("¿È");
		return new ModelAndView(new RedirectView("/main/view/" + session.getAttribute("sessionNo")));
	}

	@RequestMapping(value = "/item/{no}", method = RequestMethod.GET)
	public ModelAndView itmeView(@PathVariable int no, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/item");
		Item item = new Item();
		item.setItemSeq(no);
		item = itemService.select(item);
		modelAndView.addObject("item", item);
		return modelAndView;
	}

	@RequestMapping(value = "/item/remove/{no}", method = RequestMethod.GET)
	public ModelAndView itemRemove(@PathVariable int no, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Item item = new Item();
		Image image = new Image();
		
		System.out.println(no);
		item.setItemSeq(no);
		
		item = itemService.select(item);
		System.out.println(item.toString());
		
		String[] temp = item.getImage().split("/");
		for(int i = 1 ; i < temp.length ; i++) {
			System.out.println(temp[i].toString());
			image.setImageSeq(Integer.parseInt(temp[i].toString()));
			image = imageService.select(image);
			System.out.println(image.toString());
			imageService.delete(image);
		}
		
		itemService.delete(no);

		return new ModelAndView(new RedirectView("/main/view/" + session.getAttribute("sessionNo")));
	}
}
