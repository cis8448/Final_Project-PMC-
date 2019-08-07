package com.pmc.final_project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
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
		
		String p_id = (String)session.getAttribute("id");
		
		int num = (pageNum == null) ? 1 : pageNum;
		
		mList = mDao.getmemberAllList(p_id);
		
		mav.addObject("mList", mList);
		mav.addObject("memberPaging", getMemberPaging(num));
		view = "MemberList";
		mav.setViewName(view);
		
		return mav;
	}
	//페이징 처리용 메소드
	private String getMemberPaging(int num) {
		
		String id = (String)session.getAttribute("id");
		//전체 회원
		int maxNum = mDao.getMemberCount(id);
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
	
	public ModelAndView getmemberInfo(String m_id) {
		mav = new ModelAndView();
		String view = null;
		
		Member member = mDao.getmemberInfo(m_id);
		
		mav.addObject("member", member);
		
		view = "MemberInfo";
		mav.setViewName(view);
		
		return mav;
	}
	public String MemberTimeAdd(String m_time, String m_id) {
		
		String id=(String)session.getAttribute("id");
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("p_id", id);
		map.put("m_id", m_id);
		String Time = mDao.TimeSelect(map);
		
		String Times[] = Time.split(":"); 
		m_time = (Integer.parseInt(Times[0]) + Integer.parseInt(m_time)) + ":" + Times[1];
		map.put("m_time",m_time);
		if(mDao.memberTimeAdd(map)) {
			map.clear();
			map.put("cnt",m_time);
		}else {
			System.out.println("실패");
		}
		String json = new Gson().toJson(map);
		return json;
	}
	
	public String MemberSearch(String res) {


		String id=(String)session.getAttribute("id");
	
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("p_id", id);
		map.put("res", "%"+res+"%");
		
		System.out.println(res);
		
		List<Member> smember = mDao.memberSearch(map);
		
		String json = new Gson().toJson(smember);
		return json;
		
	}
	public ModelAndView getOMmemberAllList(Integer pageNum) {
		mav = new ModelAndView();
		String view = "OM_MemberList";
		List<Member> omList = null;

		System.out.println("여기는?");
		int num = (pageNum == null) ? 1 : pageNum;
		System.out.println("여기는?2");
		omList = mDao.getOMmemberAllList();
		
		mav.addObject("omList", omList);
		mav.addObject("OMmemberPaging", getOMmemberPaging(num));
	
		mav.setViewName(view);
		return mav;
	}
	private Object getOMmemberPaging(int num) {
		//전체 회원
		int maxNum = mDao.getOMmemberCount();
		//페이지 당 회원 수
		int listCnt = 10;
		//그룹당 페이지 수
		int pageCnt = 3;
		//게시판이 여러 종류가 있다면 
		String memberName = "OM_MemberList";
		Paging mempaging = 
			new Paging(maxNum, num, listCnt, 
						pageCnt, memberName);
				
		return mempaging.makeHtmlpaging();
	}
	public ModelAndView getOMmemberInfo(String m_id) {
		mav = new ModelAndView();
		String view = null;
		
		Member OMmember = mDao.getOMmemberInfo(m_id);
		
		mav.addObject("OMmember", OMmember);
		
		view = "OM_MemberInfo";
		mav.setViewName(view);
		
		return mav;
	}
	public String OMMemberSearch(String res) {

		String res2 = ("%"+res+"%");
		System.out.println(res);
		System.out.println(res2);

		List<Member> omsList = mDao.OMMemberSearch(res2);
		String json = new Gson().toJson(omsList);
		
		return json;
	}


}
