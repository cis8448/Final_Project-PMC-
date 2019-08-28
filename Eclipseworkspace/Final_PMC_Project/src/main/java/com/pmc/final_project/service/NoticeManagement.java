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


import com.google.gson.Gson;

import com.pmc.final_project.bean.Member;

import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.bean.PcRoomNoticeBean;

import com.pmc.final_project.bean.Reply;
import com.pmc.final_project.dao.INotice;
import com.pmc.final_project.util.Paging;



@Service
public class NoticeManagement {

	private ModelAndView mav;

	@Autowired
	private INotice nDao;

	@Autowired
	private HttpSession session;

	public ModelAndView getNoticeList(String cate) {
		mav = new ModelAndView();
		List<PcRoomNoticeBean> nl = null;
		if(cate.equals("0")) {	
			nl = nDao.getNoticeList(cate);
		}else {
			HashMap<String, String> map = new HashMap<String, String>();
			String	p_id = (String)session.getAttribute("id");
			map.put("cate", cate);
			map.put("p_id", p_id);			
			nl = nDao.getPcNoticeList(map);
		}
			
		mav.addObject("nList",nl);
		mav.addObject("cate",cate);
		mav.setViewName("NoticeList");
		return mav;
	}
	public ModelAndView getServiceList(String cate) {
		mav = new ModelAndView();
		List<PcRoomNoticeBean> nl = null;
		nl = nDao.getServiceList(cate);
		
		mav.addObject("nList",nl);
		mav.addObject("cate",cate);
		
		mav.setViewName("ServiceList");
		return mav;
	}
	public ModelAndView getNoticeDetile(String b_num) {
		mav = new ModelAndView();
		PcRoomNoticeBean nobean = nDao.getNoticeDetail(b_num);
		mav.addObject("nList",nobean);
		mav.setViewName("NoticeDetail");
		return mav;
	}
	public ModelAndView getServiceDetile(String b_num) {
		mav = new ModelAndView();
		PcRoomNoticeBean nobean = nDao.getServiceDetail(b_num);
		mav.addObject("nList",nobean);
		mav.setViewName("NoticeDetail");
		return mav;
	}
	
	public ModelAndView getNoticeUpdate(PcRoomNoticeBean noBean) {
		mav = new ModelAndView();
		noBean.setNo_p_id((String)session.getAttribute("id"));
		
		if(nDao.UpdateNotice(noBean)) {
			mav.addObject("check", 1);
		}else {
			mav.addObject("check", 0);
		}
		mav.setViewName("redirect:NoticeList?cate=1");
		return mav;
	}
	public ModelAndView getServiceUpdate(PcRoomNoticeBean noBean) {
		mav = new ModelAndView();
		noBean.setNo_p_id((String)session.getAttribute("id"));
		if(noBean.getNo_p_id().equals((nDao.SelectP_id(noBean.getNo_num()+"")))) {
		if(nDao.UpdateService(noBean)) {
			mav.addObject("check", 1);
		}else {
			mav.addObject("check", 0);
		}
		}
		mav.setViewName("redirect:ServiceList?cate=1");
		return mav;
	}
	public ModelAndView DeleteNotice(String b_num) {
		mav = new ModelAndView();
		if(nDao.DeleteNotice(b_num)) {
			mav.addObject("check","2");
		}else {
			mav.addObject("check","3");
		}
		mav.setViewName("redirect:NoticeList?cate=1");
		return mav;
	}
	public ModelAndView DeleteService(String b_num) {
		mav = new ModelAndView();
		String p_id = (String)session.getAttribute("id");
		if(p_id.equals(nDao.SelectP_id(b_num))) {
			if(nDao.DeleteService(b_num)) {
				mav.addObject("check","2");
			}else {
				mav.addObject("check","3");
			}
		}
		mav.setViewName("redirect:ServiceList?cate=1");
		return mav;
	}
	
	
	public String OMNoticeSearch(String res) {
		// TODO Auto-generated method stub
		String res2 = ("%"+res+"%");
		
		List<PcRoomNoticeBean> omsList = nDao.OMNoticeSearch(res2);
		String json = new Gson().toJson(omsList);
		
		return json;
	}
	public ModelAndView InserNotice(PcRoomNoticeBean noticeBean) {
		ModelAndView mav = new ModelAndView();
		noticeBean.setNo_p_id((String)session.getAttribute("id"));
		nDao.InserNotice(noticeBean);
		mav.setViewName("redirect:NoticeList?cate="+noticeBean.getNo_cate());
		return mav;
	}
	
	
	
	
	







	
}


