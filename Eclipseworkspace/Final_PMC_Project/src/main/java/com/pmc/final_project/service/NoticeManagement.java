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

	
	public String OMNoticeSearch(String res) {
		// TODO Auto-generated method stub
		String res2 = ("%"+res+"%");
		
		List<PcRoomNoticeBean> omsList = nDao.OMNoticeSearch(res2);
		String json = new Gson().toJson(omsList);
		
		return json;
	}
}


