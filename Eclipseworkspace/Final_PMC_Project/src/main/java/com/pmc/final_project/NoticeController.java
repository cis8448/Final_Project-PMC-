package com.pmc.final_project;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.bean.PcRoomNoticeBean;

import com.pmc.final_project.bean.Reply;
import com.pmc.final_project.service.NoticeManagement;




@Controller
public class NoticeController {

	ModelAndView mav;

	@Autowired
	NoticeManagement nm;

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/NoticeList")
	public @ResponseBody ModelAndView NoticeList(@RequestParam String cate) {

		mav = new ModelAndView();
		mav.addObject("cate","0");
		mav.setViewName("NoticeList");

		return mav;
	}

	//공지사항 작성
	@RequestMapping(value = "/NoticeWrite")
	public @ResponseBody ModelAndView NoticeWrite(@RequestParam String cate) {

		mav = new ModelAndView();
		mav.addObject("cate","0");
		mav.setViewName("NoticeWrite");

		return mav;
	}
	//글작성폼
	@RequestMapping(value ="/WriteFrm")
	public ModelAndView WriteFrm(@RequestParam String cate) {

		mav = new ModelAndView();
		mav.addObject("cate",cate);

		mav.setViewName("WriteFrm");
		return mav;
	}
	//고객센터 글작성
	@RequestMapping(value ="/WriteService")
	public ModelAndView WriteService(@RequestParam String cate) {

		mav = new ModelAndView();
		mav.addObject("cate",cate);

		mav.setViewName("WriteFrm");
		return mav;
	}


}
