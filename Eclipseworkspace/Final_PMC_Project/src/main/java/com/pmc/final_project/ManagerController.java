package com.pmc.final_project;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.service.NoticeManagement;
import com.pmc.final_project.service.PcroomManagement;

@Controller
@SessionAttributes("pr")
public class ManagerController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);


	ModelAndView mav;

	
	@Autowired
	PcroomManagement pm;

	@Autowired
	NoticeManagement nm;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/OM_Main", method = RequestMethod.GET)
	public String Main(Model model) {


		return "OM_Main";   
	}
	
}
