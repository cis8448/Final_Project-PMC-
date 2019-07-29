package com.pmc.final_project;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.service.PcroomManagement;



@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	
	ModelAndView mav;
	
	@Autowired
	PcroomManagement pm;
	
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {



		return "SeatState";   
	}

	@RequestMapping(value = "/joinfrm", method = RequestMethod.GET)//uri 매핑
	public String join1(Model model) {
		logger.info("joinfrm execute ");

		return "joinfrm";//jsp파일 이름고 ㅏ동일해야함
	}

	@RequestMapping(value="/pcroomInsert", method = RequestMethod.POST)
	public ModelAndView pcroomInsert(PcRoomBean pr) {

		logger.info("pcroomInsert execute ");

		mav = pm.pcroomInsert(pr);


		return mav;

	}
	
	@RequestMapping(value="/access", method = RequestMethod.POST )
	public ModelAndView access(PcRoomBean pr) {
		logger.info("access execute ");
		mav = pm.memberAccess(pr);
		
		return mav;
	}
	
	@RequestMapping(value="/logout" )
	public String logout() {
		session.invalidate();
		
		return "home";
		
	}
	@RequestMapping(value="/MasterNotice" )
	public String CustomerService() {
		return "MasterNotice";
		
	}
	
	@RequestMapping(value="/PcmasterNotice" )
	public String PcmasterNotice() {
		return "PcmasterNotice";
	}
	
	@RequestMapping(value="/Product" )
	public String Product() {
		
		return "Product";
		
	}
	
	@RequestMapping(value="/ProductAdd" )
	public String ProductAdd() {
		
		return "ProductAdd";
		
	}

}
