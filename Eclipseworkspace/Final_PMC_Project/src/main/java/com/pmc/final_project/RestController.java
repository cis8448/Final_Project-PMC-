package com.pmc.final_project;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.gson.Gson;
import com.pmc.final_project.dao.IPayDao;
import com.pmc.final_project.dao.IPcRoom;
import com.pmc.final_project.service.ManagerManagement;
import com.pmc.final_project.service.MemberManagement;
import com.pmc.final_project.service.NoticeManagement;
import com.pmc.final_project.service.PayListManagement;
import com.pmc.final_project.service.PcroomManagement;
import com.pmc.final_project.service.ProductManagement;
import com.pmc.final_project.service.SeatManagement;

@Controller
public class RestController {

	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	@Autowired
	private IPcRoom pDao;
	
	@Autowired
	private IPayDao paDao;

	@Autowired
	private PcroomManagement pm;
	
	@Autowired
	private ProductManagement prm;
	
	@Autowired
	private SeatManagement sm;
	
	@Autowired
	private MemberManagement mm;
	
	@Autowired
	private PayListManagement paym;
	
	@Autowired
	private ManagerManagement om;
	
	@Autowired
	private NoticeManagement nm;
	
	@Autowired
	HttpSession session;
	

	@RequestMapping(value="/PCIdCheck", method = RequestMethod.POST)  
	public @ResponseBody String idcheck(@RequestBody String userid) {
		ModelAndView mav = new ModelAndView();
		logger.info("asdasasd execute ");

		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();

		count = pDao.PCIdCheck(userid);
		map.put("cnt", count);

		String json= null;
		json = new Gson().toJson(map);


		mav.setViewName("SignUp");

		return json;
	}
	@RequestMapping(value="/accept", method = RequestMethod.POST)  
	public @ResponseBody String accept(@RequestBody String userid) {
		ModelAndView mav = new ModelAndView();
		logger.info("accept execute ");

		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();

		count = pDao.accept(userid);
		map.put("cnt", count);

		String json= null;
		json = new Gson().toJson(map);


		mav.setViewName("SeatState");

		return json;
	}
	
	

	@RequestMapping(value="/paysearch", method = RequestMethod.POST)  
	public @ResponseBody String paysearch(@RequestBody String userid) {
		ModelAndView mav = new ModelAndView();
		logger.info("accept execute ");

		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();

		count = paDao.accept(userid);
		map.put("cnt", count);

		String json= null;
		json = new Gson().toJson(map);


		mav.setViewName("MemberPayList");

		return json;
	}



	@RequestMapping(value = "/imgsave", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ModelAndView insertSeatImg(MultipartHttpServletRequest multi) {
		ModelAndView mav = new ModelAndView();
		//MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) multi;
			mav = pm.insertfileroot(multi);
			
			
		    return mav;
		   }
	
	@RequestMapping(value = "/SeatChecker", method = RequestMethod.POST,produces = "application/text; charset=utf8")
	public @ResponseBody String SeatCheck(@RequestBody String param) {
		String json = sm.seatcheck(param);
		return json;
	}
	@RequestMapping(value = "/SeatIdDetail", method = RequestMethod.POST,produces = "application/text; charset=utf8")
	public @ResponseBody String SeatIdDetail(@RequestBody String param) {
		String p_id = (String)session.getAttribute("id");
		int snum = Integer.parseInt(param);
		String json = sm.SelectIdCate(p_id , snum);
		
		return json;
	}
	@RequestMapping(value = "/specUpdate", method = RequestMethod.GET,produces = "application/text; charset=utf8")
	public @ResponseBody String specUpdate(@RequestParam("param1") String param1, @RequestParam("param2") String param2,@RequestParam("param3") String param3) {
		String p_id = (String)session.getAttribute("id");
		String json = sm.UpdateSpec(p_id,param1,param2,param3);
		
		return json;
	}
	@RequestMapping(value = "/reserveChage", method = RequestMethod.GET,produces = "application/text; charset=utf8")
	public @ResponseBody String reserveChage(@RequestParam("param1") String S_id, @RequestParam("param2")String state) {
		String json = sm.SeatreserveChage(S_id,state);
		
		return json;
	}
	
	@RequestMapping(value="/TimeAdd", method = RequestMethod.POST)  
	public @ResponseBody String TimeAdd(@RequestParam("m_id") String m_id,@RequestParam("time") String time) {
		logger.info("TimeAdd execute ");
		String json = mm.MemberTimeAdd(time ,m_id);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value="/MemberSearch", method = RequestMethod.POST,produces = "application/text; charset=utf8")  
	public @ResponseBody String MemberSearch(@RequestBody String res) {
		logger.info("MemberSearch execute ");
		String json = mm.MemberSearch(res);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value="/ProductSearch", method = RequestMethod.POST,produces = "application/text; charset=utf8")  
	public @ResponseBody String ProductSearch(@RequestBody String res) {
		logger.info("ProductSearch execute ");
		String json = prm.ProductSearch(res);
		
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value="/casearch", method = RequestMethod.POST,produces = "application/text; charset=utf8")  
	public @ResponseBody String casearch(@RequestBody String selcate) {
		logger.info("casearch execute ");
		String json = paym.casearch(selcate);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value="/datesearch", method = RequestMethod.POST,produces = "application/text; charset=utf8")  
	public @ResponseBody String datesearch(@RequestBody String plus) {
		logger.info("datesearch execute ");
		String json = paym.datesearch(plus);
		System.out.println(json);
		return json;
	}
	

	@RequestMapping(value="/OMMemberSearch", method = RequestMethod.POST,produces = "application/text; charset=utf8")  
	public @ResponseBody String OMMemberSearch(@RequestBody String res) {
		logger.info("OMMemberSearch execute ");
		String json = mm.OMMemberSearch(res);
		System.out.println(json);
		return json;
	}

	@RequestMapping(value = "/approvalx", method = RequestMethod.POST,produces = "application/text; charset=utf8")
	public @ResponseBody String approvalx(@RequestParam("param") String id) {

		logger.info("approvalx execute ");
		System.out.println("첫번째 아이디:"+id);
		String json = om.approvalx(id);
		
		return json;
	}
	@RequestMapping(value = "/OMNoticeSearch", method = RequestMethod.POST,produces = "application/text; charset=utf8")
	public @ResponseBody String OMNoticeSearch(@RequestBody String res) {

		logger.info("OMNoticeSearch execute ");
	
		String json = nm.OMNoticeSearch(res);
		
		return json;
	}
	
	@RequestMapping(value = "/block", method = RequestMethod.POST,produces = "application/text; charset=utf8")
	public @ResponseBody String block(@RequestBody String m_id) {

		logger.info("block execute ");
		String json = mm.block(m_id);
		
		return json;
	}


}
