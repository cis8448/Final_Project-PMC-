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
import com.pmc.final_project.bean.Reply;
import com.pmc.final_project.service.NoticeManagement;




@Controller
public class NoticeController {

	ModelAndView mav;
	
	@Autowired
	NoticeManagement nm;
	
	@Autowired
	HttpSession session;
	
	
	
		
	@RequestMapping(value = "/MasterNotice") //기타 공지사항 전체보기
	public String MasterNotice() {
		session.setAttribute("id", "test1");
		return "MasterNotice";
	}
	@RequestMapping(value = "/MaNoticeDetail")
	public String MaNoticeDetail() {
		
		return "MaNoticeDetail";
	}
	
	@RequestMapping(value = "/PcmasterNotice")
	public ModelAndView PcmasterNotice(Integer NoticeNum) {
		
		mav = nm.getPcmasterNotice(NoticeNum); 
		
		return mav;
	}
	
	@RequestMapping(value = "/PcNoticeWrite")
	public String PcNoticeWrite() {
		
		return "PcNoticeWrite";
	}
	
	@RequestMapping(value ="/NoticeWrite")
	public ModelAndView NoticeWrite(PcRoomNoticeBean pcroomnoticebean) {
		
		mav = nm.NoticeWrite(pcroomnoticebean);
		
		return mav;
	}
	
	@RequestMapping(value = "/contents", method = RequestMethod.GET)
	public ModelAndView contents(Integer no_num) {
		mav = nm.getContents(no_num);
		return mav;
	}
	@RequestMapping(value = "/Macontents", method = RequestMethod.GET)
	public ModelAndView Macontents(Integer no_num) {
		mav = nm.getMaContents(no_num);
		return mav;
	}
	@RequestMapping(value = "/SCcontents", method = RequestMethod.GET)
	public ModelAndView SCcontents(Integer se_num) {
		mav = nm.getSCContents(se_num);
		return mav;
	}
	@RequestMapping(value = "/replyInsert", produces = "application/json; charset=UTF-8")
	public @ResponseBody Map<String, List<Reply>> replyInsert(Reply r){

		Map<String, List<Reply>> rMap = nm.replyInsert(r);
		
		return rMap;
	}
	
	
	@RequestMapping(value = "/NoticeDelete")
	public ModelAndView NoticeDelete(Integer no_num) throws RuntimeException{
		mav = nm.NoticeDelete(no_num);
		return mav;
	}
	
 
	

	


	
	
	
	
//	@RequestMapping(value = "/NoticeUpdate")
//	public ModelAndView NoticeUpdate(Integer no_num) throws RuntimeException{
//		mav = nm.NoticeUpdate(no_num);
//		return mav;
//	}

}
