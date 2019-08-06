package com.pmc.final_project.service;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.bean.Member;
import com.pmc.final_project.dao.IMemberDao;
import com.pmc.final_project.util.Paging;
@Service
public class MemberManagement {
	
	private ModelAndView mav;
	
	@Autowired
	private IMemberDao mDao;
	
	@Autowired
	private HttpSession session;

	
	//회원 전체 가져오기
	public ModelAndView getmemberAllList(Integer pageNum) {
		mav = new ModelAndView();
		String view = null;
		List<Member> mList = null;
		
		int num = (pageNum == null) ? 1 : pageNum;
		
		mList = mDao.getmemberAllList(num);
		
		mav.addObject("mList", mList);
		mav.addObject("memberPaging", getMemberPaging(num));
		view = "MemberList";
		mav.setViewName(view);
		
		return mav;
	}
	//페이징 처리용 메소드
	private String getMemberPaging(int num) {
		//전체 회원
		int maxNum = mDao.getMemberCount();
		//페이지 당 회원 수
		int listCnt = 10;
		//그룹당 페이지 수
		int pageCnt = 3;
		//게시판이 여러 종류가 있다면 
		String memberName = "MemberList";
		Paging mempaging = 
			new Paging(maxNum, num, listCnt, 
						pageCnt, memberName);
				
		return mempaging.makeHtmlpaging();
	}
	
	public ModelAndView getMemberInfo(Integer m_id) {
		mav = new ModelAndView();
		String view = null;
		
		Member member = mDao.getmemberInfo(m_id);
		mav.addObject("member", member);
		
		view = "MemberInfo";
		mav.setViewName(view);
		
		return mav;
	}
	

}
