package com.pmc.final_project;

import java.util.HashMap;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.service.PcroomManagement;
import com.pmc.final_project.service.SeatManagement;



@Controller
@SessionAttributes("pr")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);


	ModelAndView mav;


	@Autowired
	PcroomManagement pm;

	@Autowired
	HttpSession session;



	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {


		return "Login";   
	}



	@RequestMapping(value = "/LoginFail", method = RequestMethod.GET)
	public String LoginFail(Model model) {


		return "LoginFail";   
	}
	//	@RequestMapping(value="/JSPIdOverLap", method = RequestMethod.POST)
	//	public @ResponseBody String JSPIdOverLap(@RequestBody String id) {
	//
	//		logger.info("JSPIdOverLap execute ");
	//
	//		String  str = "";
	//
	//
	//		return str;
	//
	//	}


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
	public ModelAndView JSPLoginCall(PcRoomBean pr) {
		logger.info("JSPLoginCall execute ");

		mav = pm.JSPLoginCall(pr);

		return mav;
	}



	@RequestMapping(value="/logout" )
	public String logout() {
		session.invalidate();

		return "Login";

	}

	@RequestMapping(value = "/id", method = RequestMethod.GET)//uri 매핑
	public String id(Model model) {
		logger.info("Id execute ");


		return "id";//jsp파일 이름고 ㅏ동일해야함
	}
	@RequestMapping(value = "/pw", method = RequestMethod.GET)//uri 매핑
	public String pw(Model model) {
		logger.info("pw execute ");



		return "pw";//jsp파일 이름고 ㅏ동일해야함
	}
	@RequestMapping(value="/idsearch", method = RequestMethod.POST )
	public ModelAndView idsearch(PcRoomBean pr) {
		logger.info("idsearch execute ");

		mav = pm.idsearch(pr);

		return mav;
	}
	@RequestMapping(value="/pwsearch", method = RequestMethod.POST )
	public ModelAndView pwsearch(PcRoomBean pr) {
		logger.info("pwsearch execute ");

		mav = pm.pwsearch(pr);

		return mav;
	}
	@RequestMapping(value = "/mail", method = RequestMethod.POST)//uri 매핑
	public String mail(Model model) {
		logger.info("mail execute ");


		return "mail";//jsp파일 이름고 ㅏ동일해야함
	}

	//Ajax로 처리하는 Write 메소드
	@RequestMapping(value="/fileupload" ,method = RequestMethod.POST)
	public ModelAndView boardWriteAjax(MultipartHttpServletRequest multi) {

		mav= pm.fileupload(multi);


		return mav;
	}
	@RequestMapping(value = "/PCInfoUpdate")//uri 매핑
	public ModelAndView PCInfoUpdate(PcRoomBean pr) {

		logger.info("PCInfoUpdate execute ");

		mav = pm.PCInfoUpdate(pr);

		return mav; //jsp파일 이름고 ㅏ동일해야함
	}

	@RequestMapping(value = "/InfoUpdate")//uri 매핑
	public ModelAndView InfoUpdate(PcRoomBean pr) {

		logger.info("InfoUpdate execute ");

		mav = pm.InfoUpdate(pr);

		return mav; //jsp파일 이름고 ㅏ동일해야함
	}

	@RequestMapping(value = "/changepw")//uri 매핑
	public ModelAndView changepw(PcRoomBean pr) {

		logger.info("changepw execute ");

		mav = pm.changepw(pr);

		return mav; //jsp파일 이름고 ㅏ동일해야함
	}
	@RequestMapping(value = "/changepw2")//uri 매핑
	public ModelAndView changpw2(PcRoomBean pr) {

		logger.info("changepw2 execute ");

		mav = pm.changepw2(pr);

		return mav; //jsp파일 이름고 ㅏ동일해야함
	}

	@RequestMapping(value = "/PCPictureUpdate")//uri 매핑
	public ModelAndView PCPictureUpdate(PcRoomBean pr) {

		logger.info("PCPictureUpdate execute ");

		mav = pm.PCPictureUpdate(pr);

		return mav; //jsp파일 이름고 ㅏ동일해야함
	}
	@RequestMapping(value = "/GetPicture")
	public @ResponseBody String GetPicture() {
		System.out.println("들어왓니?");
		String json = pm.GetPicture();
		System.out.println("끝");
		return json;
	}



}
