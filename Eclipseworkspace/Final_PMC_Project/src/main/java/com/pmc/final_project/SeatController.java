package com.pmc.final_project;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.service.SeatManagement;

@Controller
public class SeatController {
	
	ModelAndView mav;
	@Autowired
	HttpSession session;
	@Autowired
	SeatManagement sm;
	
	@RequestMapping(value = "/seatInsert")
	public @ResponseBody String seatInsert(MultipartHttpServletRequest multi) {

		System.out.println("와주세요 제발...");
		HashMap<String, String> ll = new HashMap<String, String>();
		boolean state = sm.SeatUpdate(multi);
		if(state) {
			ll.put("success", "성공");
		}else {
			ll.put("success", "실패");
		}
		String Json = new Gson().toJson(ll);
		return Json;
	}
	@RequestMapping(value = "/SeatState", method = RequestMethod.GET)
	public ModelAndView SeatState() {
		String p_id = (String)session.getAttribute("p_id");
		mav = sm.SelectSeat(p_id);
		return mav;   
	}

}
