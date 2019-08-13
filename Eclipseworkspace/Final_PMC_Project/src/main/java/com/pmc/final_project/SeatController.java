package com.pmc.final_project;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
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
		HashMap<String, String> ll = new HashMap<String, String>();
		boolean state = sm.SeatUpdate(multi);
		if(state) {
			ll.put("success", "1");
		}else {
			ll.put("success", "0");
		}
		String Json = new Gson().toJson(ll);
		return Json;
	}
	@RequestMapping(value = "/SeatUpdate", method = RequestMethod.GET)
	public ModelAndView SeatUpdate() {
		String p_id = (String)session.getAttribute("id");
		mav = sm.SelectSeat(p_id);
		return mav;   
	}
	@RequestMapping(value = "/SeatState", method = RequestMethod.GET)
	public ModelAndView SeatState() {
		String p_id = (String)session.getAttribute("id");
		mav = sm.SelectSeat(p_id);
		mav.setViewName("SeatState");
		return mav;   
	}
	@RequestMapping(value = "/SeatDetail", method = RequestMethod.GET)
	public ModelAndView SeatDetail() {
		String p_id = (String)session.getAttribute("id");
		mav = sm.SelectCate(p_id , 0);

		return mav;
	}
	
	@RequestMapping(value = "/GetPicture2")
	public @ResponseBody String GetPicture2(@RequestParam("id") String str) {
	
		String json = sm.GetPicture(str);
		
		return json;
	}
	@RequestMapping(value = "/Seatsearch")
	public @ResponseBody String seatSearch(@RequestParam("id")String id) {
		String json = sm.seatSearch(id);
		return json;
	}

}
