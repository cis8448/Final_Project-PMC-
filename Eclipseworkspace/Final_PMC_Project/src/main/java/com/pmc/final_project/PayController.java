package com.pmc.final_project;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.service.PayListManagement;
import com.pmc.final_project.service.PcroomManagement;

@Controller
public class PayController {
	

	
	ModelAndView mav;
	
	@Autowired
	PayListManagement pm;
	
<<<<<<< HEAD
	@Autowired
	HttpSession session;
	

	
	@RequestMapping(value = "/MemberPayList")
	public ModelAndView MemberPayList(Integer ProductNum) {
		mav = pm.getPayList(ProductNum);
		
		return mav;
	}
=======

>>>>>>> 47d79b3a7b9585688b42e5f2734691f8a60c854d
	
	
	@RequestMapping(value = "/CatePayList")
	public String CatePayList() {
		
		return "CatePayList";
	}
	@RequestMapping(value = "/TimePayList")
	public String TimePayList() {
		
		return "TimePayList";
	}
	
	

}
