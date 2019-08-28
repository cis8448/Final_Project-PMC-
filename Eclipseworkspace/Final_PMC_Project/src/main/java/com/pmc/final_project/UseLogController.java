package com.pmc.final_project;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.service.MemberManagement;
import com.pmc.final_project.service.UseLogManagement;

@Controller
public class UseLogController {

	ModelAndView mav;
	
	@Autowired
	UseLogManagement um;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/MemberUseLog")
	public @ResponseBody ModelAndView MemberUseLog(Integer pageNum, @RequestParam("m_id") String m_id) {
		mav = um.getmemberUseLog(pageNum, m_id);
		
		return mav;
	}
	@RequestMapping(value = "/SelectReserveChecking")
	   public @ResponseBody String SelectReserveChecking(@RequestParam("id") String id) {
		 System.out.println("SelectReserveChecking");
		   String json = um.SelectReserveChecking(id);
		   return json;
	   }
	 
	 @RequestMapping(value = "/BookMarkList")
	   public @ResponseBody String BookMarkList(@RequestParam("id") String id) {
		 	System.out.println("BookMarkList");
		   String json = um.BookMarkList(id);
		   return json;
	   }
//	 @RequestMapping(value = "/GetUseLog",produces = "application/text; charset=utf8")
//	   public @ResponseBody String Getuselog(@RequestParam("id") String id) {
//	   
//	      String json = um.Getuselog(id);
//	      
//	      return json;
//	   }

	
}
