package com.market.presentation;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.market.domain.Image;
import com.market.domain.Item;
import com.market.domain.Keyword;
import com.market.domain.Member;
import com.market.domain.Profile;
import com.market.service.ImageService;
import com.market.service.ItemService;
import com.market.service.KeywordService;
import com.market.service.MemberService;
import com.market.service.ProfileService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private KeywordService keywordService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGET(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/login");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPOST(HttpServletRequest request, Member member) {
		member = memberService.select(member);
		if (member == null) {
			return new ModelAndView("/login");
		} else {

			HttpSession session = request.getSession();
			session.setAttribute("sessionNo", member.getMemberSeq());
			session.setAttribute("id", member.getId());
			session.setAttribute("nick", member.getNick());
			return new ModelAndView(new RedirectView("/main"));
		}
	}

	@RequestMapping(value = "/main/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
		}

		return new ModelAndView(new RedirectView("/login"));
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/write");
		return modelAndView;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView mainGET(HttpServletRequest request, Member member)
			throws IOException {
		ModelAndView modelAndView = new ModelAndView("/main");

		List<Member> list = memberService.list(member);

		Image image = new Image();
		List<Image> imageList = new ArrayList<>();
		Profile profile = new Profile();
		List<Profile> profileList = profileService.list(profile);

		member = new Member();
		Item item = new Item();
		Keyword keyword = new Keyword();

		list = memberService.list(member);
		List<Item> itemList = itemService.list(item);

		for (int i = 0; i < itemList.size(); i++) {
			String[] temp = itemList.get(i).getImage().split("/");
			image.setImageSeq(Integer.parseInt(temp[1].toString()));
			imageList.add(imageService.select(image));
		}
		List<Keyword> keywordList = keywordService.list(keyword);

		for (int i = 0; i < imageList.size(); i++) {
		}
		modelAndView.addObject("memberList", list);
		modelAndView.addObject("itemList", itemList);
		modelAndView.addObject("imageList", imageList);
		modelAndView.addObject("keywordList", keywordList);
		modelAndView.addObject("profileList", profileList);

		return modelAndView;
	}

	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public @ResponseBody List<Keyword> main(@RequestBody String input, HttpServletRequest request) throws IOException {
		List<Keyword> keywordList = new ArrayList<Keyword>();
		Keyword keyword = new Keyword();
		input = URLDecoder.decode(input.split("[=]")[1].trim() , "UTF-8"); //ÇÑ±Û ±úÁü ¹æÁö
		
		System.out.println("°Ë»ö           " + input);
		keyword.setKeyword(input);
		
		keywordList = keywordService.list(keyword);
		
		for(int i = 0 ; i< keywordList.size() ; i++) {
			System.out.println(keywordList.get(i).getKeyword());
		}
		return keywordList;
	}

	@RequestMapping(value = "/main/view/{no}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable int no, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/view");
		Member member = new Member();
		Item item = new Item();
		member.setMemberSeq(no);
		member = memberService.select(member);
		item.setMemberSeq(member.getMemberSeq());

		List<Item> itemList = itemService.list(item);

		modelAndView.addObject("member", member);
		modelAndView.addObject("itemList", itemList);
		return modelAndView;

	}
}
