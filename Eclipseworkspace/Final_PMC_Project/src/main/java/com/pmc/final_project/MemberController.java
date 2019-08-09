package com.pmc.final_project;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.service.MemberManagement;

@Controller
public class MemberController {
	
	ModelAndView mav;
	
	@Autowired
	MemberManagement mm;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/MemberList")
	public ModelAndView MemberList(Integer pageNum) {
		mav = mm.getmemberAllList(pageNum);
		
		return mav;
	}
	
	@RequestMapping(value="/MemberInfo")
	public ModelAndView MemberInfo(String m_id) {
		mav = mm.getmemberInfo(m_id);
		
		return mav;
	}   
	
	@RequestMapping(value="/OM_MemberList")
	public ModelAndView OM_MemberList(Integer pageNum) {
		mav = mm.getOMmemberAllList(pageNum);
		
		return mav;
	}
	
	@RequestMapping(value="/OM_MemberInfo")
	public ModelAndView OM_MemberInfo(String m_id) {
		mav = mm.getOMmemberInfo(m_id);
		
		return mav;
	}
	
}
