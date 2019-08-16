package com.pmc.final_project;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@RequestMapping(value = "/Seatsearch")
	public @ResponseBody String seatSearch(@RequestParam("id")String id) {
		String json = sm.seatSearch(id);
		return json;
	}
	
	@RequestMapping(value = "/GetPicture2")
	   public @ResponseBody String GetPicture2(@RequestParam("id") String str) {
	      
	      String json = sm.GetPicture2(str);
	      
	      return json;
	   }
	   
	   @RequestMapping(value = "/GetSeatList",produces = "application/text; charset=utf8")
	   public @ResponseBody String GetSeatList(@RequestParam("id") String id) {
	   
	      String json = sm.GetSeatList(id);
	      
	      return json;
	   }
	   @RequestMapping(value = "/reserve")
	   public @ResponseBody String InsertMember(@RequestBody Map map) {
	      
	      String json = sm.reserve(map);
	      return json;
	   }
	   
	   @RequestMapping(value = "/reserveConfirm")
	   public @ResponseBody String reserveConfirm(@RequestBody Map map) {
	      System.out.println(map.get("m_id").toString()+map.get("p_id").toString());
	      String json = sm.reserveConfirm(map);
	      return json;
	   }
	   
	   @RequestMapping(value = "/reserveDelete")
	   public @ResponseBody String reserveDelete(@RequestBody Map map) {
	      
	      String json = sm.reserveDelete(map);
	      return json;
	   }

}
