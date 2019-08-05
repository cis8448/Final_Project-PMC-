package com.pmc.final_project.service;

import java.util.*;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.dao.IPcRoom;

@Service
public class ManagerManagement {
	private ModelAndView mav;

	@Autowired
	private IPcRoom pDao;

	@Autowired
	private HttpSession session;

	public String PCApproval(String param) {
		// TODO Auto-generated method stub
		List<PcRoomBean> sbpc = pDao.selectAll(param);
		String PCrList = sbpc.size()+"";
		System.out.println(PCrList);
		String json = new Gson().toJson(sbpc);
		mav.addObject("PCrList",PCrList);
		mav.setViewName("OM_Main");
		return json;
	}
	
	
	
}
