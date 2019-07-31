package com.pmc.final_project;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.HomesUserDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.service.PcroomManagement;
import com.pmc.final_project.service.SeatManagement;



@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	
	ModelAndView mav;
	
	@Autowired
	PcroomManagement pm;
	@Autowired
	SeatManagement sm;
	
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		

		return "SeatState";   
	}
	@RequestMapping(value="/JSPIdOverLap", method = RequestMethod.POST)
	public @ResponseBody String JSPIdOverLap(@RequestBody String id) {

		logger.info("JSPIdOverLap execute ");

		String  str = "";


		return str;

	}
	@RequestMapping(value = "/seatInsert")
	public @ResponseBody String seatInsert(MultipartHttpServletRequest multi) {
	
		System.out.println("와주세요 제발...");
		HashMap<String, String> ll = new HashMap<String, String>();
		ll.put("success", ",씨발");
		String Json = new Gson().toJson(ll);
		
		sm.SeatUpdate(multi);
		
		return Json;
	}

	@RequestMapping(value = "/SignUp", method = RequestMethod.GET)//uri 매핑
	public String SignUp(Model model) {
		logger.info("SignUp execute ");

		return "SignUp";//jsp파일 이름고 ㅏ동일해야함
	}

	@RequestMapping(value="/JSPSignUp", method = RequestMethod.POST)
	public ModelAndView JSPSignUp(PcRoomBean pr) {

		logger.info("JSPSignUp execute ");

		mav = pm.JSPSignUp(pr);


		return mav;

	}
	
	@RequestMapping(value="/JSPLoginCall", method = RequestMethod.POST )
	public ModelAndView access(PcRoomBean pr) {
		logger.info("JSPLoginCall execute ");
		mav = pm.JSPLoginCall(pr);
		
		return mav;
	}
	
	@RequestMapping(value="/logout" )
	public String logout() {
		session.invalidate();
		
		return "home";
		
	}

}
