package com.pmc.final_project;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.bean.Paybean;
import com.pmc.final_project.service.PayListManagement;


@Controller
public class PayController {
	

	
	ModelAndView mav;
	
	@Autowired
	PayListManagement pm;
	
	

	@Autowired
	HttpSession session;
	

	
	@RequestMapping(value = "/MemberPayList")
	public ModelAndView MemberPayList(Integer ProductNum) {
		mav = pm.getPayList(ProductNum);
		
		return mav;
	}

	@RequestMapping(value = "/CatePayList")
	public ModelAndView CatePayList(Integer CateNum) {
		mav = pm.getCateList(CateNum);
		
		return mav;
	}
	   
	 

	
	@RequestMapping(value = "/MemberPayCheck")
	public @ResponseBody ModelAndView MemberPayCheck(Integer pageNum, @RequestParam("m_id") String m_id) {
		
		mav = pm.getmemberPayList(pageNum, m_id);
		
		return mav;
	}
	
	@RequestMapping(value = "/EndingPay")
	public @ResponseBody String EndingPay(@RequestParam("id") String id,@RequestBody ArrayList<Paybean> payBean) {
		String json = pm.insertPay(id,payBean);
		return json;
	}
	@RequestMapping(value = "/SelectPayList1",produces = "application/text; charset=utf8")
	public @ResponseBody String SelectPayList1(@RequestParam("id") String id) {
		System.out.println("SelectPayList1");
		String json = pm.SelectPayList1(id);
		return json;
	}
	

}
