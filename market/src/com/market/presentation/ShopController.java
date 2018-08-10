package com.market.presentation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.market.domain.Item;
import com.market.domain.Keyword;
import com.market.domain.ViewCheck;
import com.market.service.ItemService;
import com.market.service.KeywordService;
import com.market.service.MemberService;
import com.market.service.ViewCheckService;

@Controller
public class ShopController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private KeywordService keywordService;
	@Autowired
	private ViewCheckService viewCheckService;
 
	@RequestMapping(value = "/main/keyword/{no}", method = RequestMethod.GET)
	public ModelAndView keyword(@PathVariable int no, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/keyword");
		HttpSession httpSession = request.getSession();
		Keyword keyword = new Keyword();
		keyword.setKeywordSeq(no);

		keyword = keywordService.select(keyword);

		String key = keyword.getKeyword();
		
		keyword.setLook(keyword.getLook());
		
		
		ViewCheck viewCheck = new ViewCheck();
		viewCheck.setMemberSeq((int)(httpSession.getAttribute("sessionNo")));
		viewCheck.setkeywordSeq(no);
		
		keyword.setMemberSeq((int)(httpSession.getAttribute("sessionNo")));
		System.out.println(viewCheck.toString());
		
		System.out.println(keyword.toString());
		viewCheckService.insert(viewCheck);
		
		keywordService.update(keyword);
		
		
		int index = key.indexOf("#");

		key = key.substring(index + 1);
		
		Item item = new Item();
		item.setTag(key);
		List<Item> itemList = itemService.list(item);

		modelAndView.addObject("keyword", key);
		modelAndView.addObject("itemList", itemList);
		return modelAndView;
	}
}
