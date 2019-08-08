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
	

	//전체 공지사항 출력
	@RequestMapping(value = "/NoticeList") 
	public @ResponseBody ModelAndView NoticeList(Integer pageNum, @RequestParam String cate) {

		mav = nm.getNoticeList(pageNum, cate);
		mav.addObject("cate",cate);

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

			mav.setViewName("WriteService");
			return mav;
		}

		@RequestMapping(value = "/writeinsert")
		public ModelAndView writeinsert(PcRoomNoticeBean pcRoomNoticeBean) {

			mav = nm.writeinsert(pcRoomNoticeBean);

			return mav;
		}
		//공지사항 글삭제
		@RequestMapping(value = "/NoticeDelete")
		public ModelAndView NoticeDelete(String no_num) {

			mav = nm.NoticeDelete(no_num);

			return mav;
		}
		//업데이트
		@RequestMapping(value = "/NoticeUpdate")
		public ModelAndView NoticeUpdate(PcRoomNoticeBean Nbean){
			mav = nm.NoticeUpdate(Nbean);
			return mav;
		}
		@RequestMapping(value = "/NoticeUpdateOpen")
		public ModelAndView NoticeUpdateOpen(String no_num){
			PcRoomNoticeBean pr = new PcRoomNoticeBean();
			pr.setNo_num(Integer.parseInt(no_num));
			mav = nm.NoticeDetail(pr);
			mav.setViewName("NoticeUpdate");
			return mav;
		}


		//공지사항 상세보기
		@RequestMapping(value = "/NoticeDetail")
		public ModelAndView NoticeDetail(PcRoomNoticeBean pr) {

			mav = nm.NoticeDetail(pr);

			return mav;
		}

		@RequestMapping(value = "/ServiceList") 
		public @ResponseBody ModelAndView ServiceList(Integer pageNum, @RequestParam String cate) {

			mav = nm.getServiceList(pageNum, cate);
			mav.addObject("cate",cate);

			return mav;
		}

		@RequestMapping(value = "/replyInsert", produces = "application/json; charset=UTF-8")
		public @ResponseBody Map<String, List<Reply>> replyInsert(Reply r){
			Map<String, List<Reply>> rMap = nm.replyInsert(r);
			return rMap;
		}



		@RequestMapping(value = "/OM_Nwrite")
		public String OM_Nwrite() {

			return "OM_Nwrite";
		}


	}
