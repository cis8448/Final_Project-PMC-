package com.pmc.final_project.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.SeatBean;
import com.pmc.final_project.dao.ISeatDao;
@Service
public class SeatManagement {
	
	ModelAndView mav;
	
	@Autowired
	ISeatDao sDao;

	public String SeatUpdate(MultipartHttpServletRequest multi) {
		
		ArrayList<String> seatv = new ArrayList<>(); 
		
		 Enumeration params = multi.getParameterNames();
		 String p_id = null;
		 
		 while(params.hasMoreElements()){
		 String names = (String)params.nextElement();
		 if(names.equals("P_id")) {
			 p_id = multi.getParameter(names);
		 }else {
			 seatv.add(multi.getParameter(names));
		 }
		 }
		 //DB에서 해당 pc방 좌석 갯수 가져로기
		 int datacnt = sDao.selectCount(p_id);
		 //DB값과 requst값이 같을때 처리
		 if(seatv.size() == datacnt) {
			 HashMap<String, String> list = new HashMap<String, String>();
			 list.put("state", "0");
			 String Json = new Gson().toJson(list);
			 return Json;
		 //DB값보다 requst값 클때
		 }else if(seatv.size() > datacnt) {
			 int size = seatv.size() - datacnt -1;
			 for(int i = size; i > seatv.size() ;i--) {
				 SeatBean sb = new SeatBean();
				 sb.setP_id(p_id);
				 sb.setS_id("pc"+p_id+i);
				 sb.setS_state("대기");
				 sb.setS_noreserve("불가");
				 sDao.insertSeat(sb);
			 }
		 }else if(seatv.size() < datacnt) {
			List<SeatBean> beans = sDao.selectAll(p_id);
			 int size = datacnt - seatv.size() -1;
			for(int i = beans.size()-size-1; i < beans.size(); i++) {
				sDao.deleteSeat(beans.get(i));
			}
		 }
		 
		 
		return null;
	}
	

	
}
