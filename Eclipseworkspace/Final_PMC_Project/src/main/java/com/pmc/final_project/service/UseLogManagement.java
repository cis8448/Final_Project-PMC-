package com.pmc.final_project.service;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.UseLogBean;
import com.pmc.final_project.dao.IUseLogDao;
import com.pmc.final_project.util.Paging;

@Service
public class UseLogManagement {

	private ModelAndView mav;
	
	@Autowired
	private IUseLogDao uDao;
	
	@Autowired
	private HttpSession session;

	public ModelAndView getmemberUseLog(Integer pageNum, String m_id) {
		mav = new ModelAndView();
		String view = null;
		List<UseLogBean> uList = null;
		int num = (pageNum == null) ? 1 : pageNum;
		System.out.println(m_id);
		
		uList = uDao.getmemberuseLog(m_id);

		
		mav.addObject("uList", uList);
		mav.addObject("uselogPaging", getUseLogPaging(num, m_id));
		
		view = "MemberUseLog";
		mav.setViewName(view);
		
		return mav;
	}

	private String getUseLogPaging(int num, String m_id) {
		//전체 회원
		int maxNum = uDao.getUseLogCount(m_id);
		//페이지 당 회원 수
		int listCnt = 10;
		//그룹당 페이지 수
		int pageCnt = 3;
		//게시판이 여러 종류가 있다면 
		String uselogName = "MemberUseLog";
		Paging mempaging = 
			new Paging(maxNum, num, listCnt, 
						pageCnt, uselogName);
				
		return mempaging.makeHtmlpaging();
	}

//	public String Getuselog(String id) {
//		// TODO Auto-generated method stub
//		id = "pc"+id+"%";
//		
//		ArrayList<UseLogBean> a = uDao.Getuselog(id);
//		String json = new Gson().toJson(a);
//		
//		return json;
//	}
}

	
	
