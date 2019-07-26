package com.pmc.final_project;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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

import com.pmc.final_project.service.MemberManagement;
import com.pmc.final_project_bean.Member;


@Controller
@SessionAttributes("mb")
//모델 객체 mb를 생성하면 request 영역에 저장.
public class HomeController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(HomeController.class);
	
	ModelAndView mav;
	
	@Autowired
	MemberManagement mm;//Service 클래스를 찾아서 객체 생성
	
	@Autowired
	HttpSession session;
	

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "home";
	}
	
	@RequestMapping(value = "/joinFrm", method = RequestMethod.GET)
	public String joinFrm(Model model) {
		logger.info("joinFrm execute.");		
		return "joinFrm";
	}
	
	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public ModelAndView memberInsert(Member mb) {
		logger.info("memberInsert execute.");
		
		mav = mm.memberInsert(mb);
		
		return mav;
	}
	
	@RequestMapping(value = "/access", 
			method = RequestMethod.POST)
	public ModelAndView access(Member mb) {
		mav = mm.memberAccess(mb);
		return mav;
	}
	
	@RequestMapping(value = "/logout")
	   public String logout() {
	      session.invalidate();
	      return "home";
	   }
	

}