package com.pmc.final_project.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.bean.Member;
import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.bean.PcRoomNoticeBean;
import com.pmc.final_project.bean.PcRoomSCBean;
import com.pmc.final_project.bean.Reply;
import com.pmc.final_project.dao.INotice;
import com.pmc.final_project.util.Paging;



@Service
public class NoticeManagement {

	private ModelAndView mav;

	@Autowired
	private INotice nDao;

	@Autowired
	HttpSession session;
	
	public ModelAndView getNoticeList(Integer pageNum) {
		mav = new ModelAndView();
		String view = null;
		List<PcRoomNoticeBean> nList = null;
		
		String p_id = (String)session.getAttribute("id");
		
		int num = (pageNum == null) ? 1 : pageNum;
		
		nList = nDao.getNoticeList(p_id);
		
		mav.addObject("nList", nList);
		mav.addObject("memberPaging", getNoticePaging(num));
		view = "NoticeList";
		mav.setViewName(view);
		
		return mav;
	}

	private String getNoticePaging(int num) {

		String id = (String)session.getAttribute("id");
		//전체 회원
		int maxNum = nDao.getNoticeCount(id);
		//페이지 당 회원 수
		int listCnt = 10;
		//그룹당 페이지 수
		int pageCnt = 3;
		//게시판이 여러 종류가 있다면 
		String NoticeName = "NoticeList";
		Paging mempaging = 
			new Paging(maxNum, num, listCnt, 
						pageCnt, NoticeName);
				
		return mempaging.makeHtmlpaging();
	}
	

	

}


