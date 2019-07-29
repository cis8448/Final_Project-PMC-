package com.pmc.final_project;

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
	
	@RequestMapping(value = "/MemberPayList")
	public ModelAndView MemberPayList(Integer ProductNum) {
		mav = pm.getPayList(ProductNum);
		
		return mav;
	}
}
