package com.pmc.final_project;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.bean.PcRoomNoticeBean;
import com.pmc.final_project.bean.PcRoomSCBean;
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
	public ModelAndView NoticeList(Integer pageNum) {
		mav = nm.getNoticeList(pageNum);
		
		return mav;
	}
	//공지사항 작성
	@RequestMapping(value = "/NoticeWrite")
	public String PcNoticeWrite() {
		
		return "PcNoticeWrite";
	}

	//공지사항 상세보기
	@RequestMapping(value = "/NoticeDetail")
	public String MaNoticeDetail() {
		
		return "MaNoticeDetail";
	}

	
	
//	댓글
//	@RequestMapping(value = "/replyInsert", produces = "application/json; charset=UTF-8")
//	public @ResponseBody Map<String, List<Reply>> replyInsert(Reply r){
//
//		Map<String, List<Reply>> rMap = nm.replyInsert(r);
//		
//		return rMap;
//	}
	
//	//글삭제
//	@RequestMapping(value = "/NoticeDelete")
//	public ModelAndView NoticeDelete(Integer no_num) throws RuntimeException{
//		mav = nm.NoticeDelete(no_num);
//		return mav;
//	}
//	
	//업데이트
//	@RequestMapping(value = "/NoticeUpdate")
//	public ModelAndView NoticeUpdate(Integer no_num) throws RuntimeException{
//		mav = nm.NoticeUpdate(no_num);
//		return mav;
//	}

}
