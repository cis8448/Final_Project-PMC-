package com.pmc.final_project;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.service.PayListManagement;


@Controller
public class PayController {
	

	
	ModelAndView mav;
	
	@Autowired
	PayListManagement pm;
	

	@Autowired
	HttpSession session;
	

	
	@RequestMapping(value = "/MemberPayList")
	public ModelAndView MemberPayList(Integer ProductNum) {
		mav = pm.getPayList(ProductNum);
		
		return mav;
	}

	

	
	@RequestMapping(value = "/TimePayList")
	public String TimePayList() {
		
		return "TimePayList";
	}
	
	

}
