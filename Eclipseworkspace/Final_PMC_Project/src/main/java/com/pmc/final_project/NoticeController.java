package com.pmc.final_project;


import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.bean.PcRoomNoticeBean;
import com.pmc.final_project.service.NoticeManagement;




@Controller
public class NoticeController {

	ModelAndView mav;
	
	@Autowired
	NoticeManagement nm;
	
	@Autowired
	HttpSession ss;
	
	@RequestMapping(value = "/MasterNotice") //기타 공지사항 전체보기
	public String MasterNotice() {
		ss.setAttribute("id", "20111");
		return "MasterNotice";
	}
	@RequestMapping(value = "/NoticeDetail")
	public ModelAndView NoticeDetail() {
		
		return mav;
	}
	
	@RequestMapping(value = "/PcMasterNotice")
	public String PcmasterNotice( ) {
		
		return "PcmasterNotice";
	}
	
	@RequestMapping(value = "/PcNoticeWrite") // 게시글 작성화면 오픈
	//Method를 생략하면 GET, POST 둘 다 처리
	public ModelAndView PcNoticeWrite(PcRoomNoticeBean pcroomnotice) {
		mav = nm.PcNoticeWrite(pcroomnotice);
		
		return mav;
	}
	

}
