package com.pmc.final_project;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.service.CateListManagement;

@Controller
public class ProductCateController {

	ModelAndView mav;
	
	@Autowired
	CateListManagement cm;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/CatePayList")
	public ModelAndView CatePayList(Integer CateNum) {
		mav = cm.getCateList(CateNum);
		
		return mav;
	}
	
	@RequestMapping(value = "/cateajax", method = RequestMethod.GET)
	public ModelAndView cateajax(@RequestParam("a") String a) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("a",a);
			
		mav.setViewName("CatePayList");
			
		return mav;
	}
	
}
