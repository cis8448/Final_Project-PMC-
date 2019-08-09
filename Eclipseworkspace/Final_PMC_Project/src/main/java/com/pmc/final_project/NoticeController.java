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

	@RequestMapping(value = "/NoticeList")
	public ModelAndView boardList(String Cate) {
		mav = nm.getNoticeList(Cate);
		return mav;
	}

	@RequestMapping(value = "./NoticeDetail")
	public ModelAndView boardDetail(@RequestParam("b_num")String b_num) {
		mav = nm.getNoticeDetile(b_num);
		return mav;
	}
	@RequestMapping(value = "./NoticeUpdateOpen")
	public String NoticeUpdateOpen(PcRoomNoticeBean noBean) {
		return "NoticeUpdate";
	}
	@RequestMapping(value = "NoticeUpdate")
	public ModelAndView NoticeUpdate(PcRoomNoticeBean noBean) {
		mav = nm.getNoticeUpdate(noBean);
		return mav;
	}
	@RequestMapping(value = "NoticeDelete")
	public ModelAndView NotoceDelete(String b_num) {
		mav = nm.DeleteNotice(b_num);

		return mav;
	}
	@RequestMapping(value = "/ServiceList")
	public ModelAndView ServiceList(String Cate) {
		mav = nm.getServiceList(Cate);
		return mav;
	}

	@RequestMapping(value = "./ServiceDetail")
	public ModelAndView ServiceDetail(@RequestParam("b_num")String b_num) {
		mav = nm.getServiceDetile(b_num);
		return mav;
	}
	@RequestMapping(value = "ServiceUpdate")
	public ModelAndView ServiceUpdate(PcRoomNoticeBean noBean) {
		mav = nm.getServiceUpdate(noBean);
		return mav;
	}
	@RequestMapping(value = "ServiceDelete")
	public ModelAndView ServiceDelete(String b_num) {
		mav = nm.DeleteService(b_num);

		return mav;
	}
	//	@RequestMapping(value = "/OM_Nwrite")
	//	public String OM_Nwrite() {
	//
	//		mav.setViewName("WriteFrm");
	//
	//		return mav;
	//	}


}
