package com.pmc.final_project;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.service.MemberManagement;

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
	
	@RequestMapping(value="/UsedMemberList")
	public String UsedMemberList() {
		
		return "UsedMemberList";
	}
	
	@RequestMapping(value="/ReseveMemberList")
	public String ReseveMemberList() {
		
		return "ReseveMemberList";
	}
	
}
