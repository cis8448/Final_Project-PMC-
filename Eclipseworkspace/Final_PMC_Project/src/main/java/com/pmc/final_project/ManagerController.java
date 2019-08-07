package com.pmc.final_project;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.service.ManagerManagement;
import com.pmc.final_project.service.NoticeManagement;
import com.pmc.final_project.service.PcroomManagement;
import com.pmc.final_project.service.SeatManagement;

@Controller
public class ManagerController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);


	ModelAndView mav;


	@Autowired
	PcroomManagement pm;

	@Autowired
	NoticeManagement nm;

	@Autowired
	ManagerManagement om;

	@Autowired
	SeatManagement sm;

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/OM_Main", method = RequestMethod.GET)
	public String Main(Model model) {


		return "OM_Main";   
	}
	
	


	@RequestMapping(value="/OM_Approval", method = RequestMethod.GET)
	public ModelAndView JSPSignUp(Integer pageNum) {

		logger.info("OM_Approval execute ");

		mav = om.OM_Approval(pageNum);


		return mav;

	}

	@RequestMapping(value = "/approval", method = RequestMethod.POST,produces = "application/text; charset=utf8")
	public @ResponseBody String approval(@RequestBody String id) {

		logger.info("approval execute ");
		System.out.println("첫번째 아이디:"+id);
		String json = om.approval(id);

		return json;
	}

	@RequestMapping(value = "/negative", method = RequestMethod.POST,produces = "application/text; charset=utf8")
	public @ResponseBody String negative(@RequestBody String id) {

		logger.info("negative execute ");

		String json = om.negative(id);

		return json;
	}

	@RequestMapping(value = "/OM_PCDetail", method = RequestMethod.GET,produces = "application/text; charset=utf8")
	public ModelAndView OM_PCDetail(@RequestParam("param") String id) {

		mav = new ModelAndView();
		logger.info("OM_PCDetail execute ");

		mav = om.OM_PCDetail(id);


		return mav;
	}

	@RequestMapping(value="/download")
	public void download(@RequestParam Map<String,Object> params,
			HttpServletRequest req,HttpServletResponse resp) throws Exception {
		//파일 경로 설정을 위한 루트 경로 구하기
		params.put("root",req.getSession().getServletContext().getRealPath("/"));
		params.put("resp",resp);
		om.downLoad(params);
	}

	@RequestMapping(value="/OM_Approvalx", method = RequestMethod.GET)
	public ModelAndView OM_Approvalx(Integer pageNum) {

		logger.info("OM_Approvalx execute ");

		mav = om.OM_Approvalx(pageNum);


		return mav;

	}
	@RequestMapping(value = "/OM_SeatState", method = RequestMethod.GET)
	public ModelAndView SeatState(@RequestParam("p_id") String p_id) {

		mav = sm.SelectSeat(p_id);
		mav.setViewName("OM_SeatState");
		return mav;   

	}

	@RequestMapping(value = "/OM_Notice", method = RequestMethod.GET)
	public ModelAndView OM_Notice(Integer pageNum,@RequestParam String cate) {

		mav = om.OM_Notice(pageNum,cate);


		return mav;
	}
	@RequestMapping(value = "/OM_Service", method = RequestMethod.GET)
	public ModelAndView OM_Service(Integer pageNum,@RequestParam String cate) {

		mav = om.OM_Service(pageNum,cate);


		return mav;
	}
	@RequestMapping(value = "/OM_NoticeInfo")
	public ModelAndView OM_NoticeInfo(String no_num) {

		mav = om.OM_NoticeInfo(no_num);


		return mav;
	}
	@RequestMapping(value = "/OM_ServiceInfo")
	public ModelAndView OM_ServiceInfo(String no_num) {

		mav = om.OM_ServiceInfo(no_num);


		return mav;
	}


}
