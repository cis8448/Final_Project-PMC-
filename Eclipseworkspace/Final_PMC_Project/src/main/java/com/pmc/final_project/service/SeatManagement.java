package com.pmc.final_project.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.Folder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pmc.final_project.bean.FileBean;

import com.pmc.final_project.bean.SeatBean;
import com.pmc.final_project.dao.IFileDao;
import com.pmc.final_project.dao.ISeatDao;
@Service
public class SeatManagement {
	
	ModelAndView mav;
	
	@Autowired
	ISeatDao sDao;
	
	@Autowired
	IFileDao fDao;
	
	boolean f;

	public boolean SeatUpdate(MultipartHttpServletRequest multi) {
		
		ArrayList<String> seatv = new ArrayList<>(); 
		
		 Enumeration params = multi.getParameterNames();
		 String p_id = null;
		 String num = null;
		 String src = null;
		 
		 while(params.hasMoreElements()){
		 String names = (String)params.nextElement();
		 if(names.equals("p_id")) {
			 p_id = multi.getParameter(names);
		 }else if(names.equals("num")){
			 num = multi.getParameter(names);
		 }else if(names.equals("src")){
			 src = multi.getParameter(names);
			 src = src.substring(src.lastIndexOf("/")+1);
		 }else {
		 
			seatv.add(multi.getParameter(names));
		 }
		 }
		 //DB에서 해당 pc방 좌석 갯수 가져로기
		 int datacnt = sDao.selectCount(p_id);
		 //DB값과 requst값이 같을때 처리
		 if(seatv.size() == datacnt) {
			 
		 //DB값보다 requst값 클때
		 }else if(seatv.size() > datacnt) {
			 
			 int size = datacnt;
			 
			 
			 for(int i = 0;i < seatv.size() ;i++) {
				 for(int j =size; j <= seatv.size(); j++) {
					 if(seatv.get(i).equals(j+"")){
						 SeatBean sb = new SeatBean();
						 sb.setP_id(p_id);
						 sb.setS_id("pc"+p_id+j);
						 System.out.println("pc"+p_id+j);
						 sb.setS_state("대기");
						 sb.setS_noreserve("불가");
						 f=sDao.insertSeat(sb);
						 break;
					 }
				 }
				 
			 }
		 }else if(seatv.size() < datacnt) {
			List<SeatBean> beans = sDao.selectAll(p_id);
			int size = datacnt - seatv.size()-1;
			for(int i = beans.size()-1; i > 0; i--) {
				if(seatv.size()-1 == seatv.size()+size) {
					break;
				}
				if(beans.get(i).getS_id().equals((seatv.size()+size)+"")){
					beans.get(i).setS_id("pc"+p_id+beans.get(i).getS_id());
					sDao.deleteSeat(beans.get(i));
					size--;
					i = beans.size();
				}
			}
		 }
		 
		 //파일업로드 
		 if(num.equals("1")) {
			 String root = "C:\\Users\\52\\Documents\\Final_Project-PMC-\\Eclipseworkspace\\Final_PMC_Project\\src\\main\\webapp\\";
			 
				String path = root + "resources\\"+p_id;
				System.out.println(src);
				
				
				File dir = new File(path);
				
				if(!dir.exists()) {
					dir.mkdir();
				}else {
					fDao.delete(p_id);
				}
				File[] list = dir.listFiles();
				if(list != null) {
				for(int i = 0; i < list.length; i++) {
					if(src.equals(list[i].getName())) {
						list[i].delete();
					}
				}
				}
			
				Iterator<String> files = multi.getFileNames();

				Map<String, String> fMap = new HashMap<String, String>();
				fMap.put("p_id", p_id);

				
				while(files.hasNext()) {
					String fileName = files.next();

					MultipartFile mf = multi.getFile(fileName);
					String oriName = mf.getOriginalFilename();
					fMap.put("oriFileName", oriName);
					
					String sysName = System.currentTimeMillis()
							+ oriName.substring
							(oriName.lastIndexOf("."));
					fMap.put("sysFileName",sysName);

					try {
						mf.transferTo(new File(path +"\\"+ sysName));
						//파일 데이터 저장
						f=fDao.fileInsert(fMap);
						
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
		 }
		 return f;
	}

	public ModelAndView SelectSeat(String p_id) {
		mav = new ModelAndView();
		String View = "SeatUpdate";
		List<SeatBean> seats = sDao.selectAll(p_id);
		List<SeatBean> seatset = new ArrayList<SeatBean>();
		for(int i =0;i < seats.size();i++) {
			for(int j = 0; j < seats.size(); j++) {
				if(seats.get(j).getS_id().equals("pc"+p_id+i)) {
					seatset.add(seats.get(j));
				}
			}
		}
		mav.addObject("Slist", seatset);
		mav.addObject("cnt",seats.size());
		FileBean fileroot = fDao.SelectFile(p_id);
		if(fileroot != null) {
		fileroot.setC_content(fileroot.getC_p_id() + "\\" + fileroot.getC_content());
		}
		mav.addObject("Sfile", fileroot);
		mav.setViewName(View);

		return mav;
	}

	public String seatcheck(String param) {
		List<SeatBean> seats = sDao.selectAll(param);
		System.out.println(param);
		List<SeatBean> seatset = new ArrayList<SeatBean>();
		
		for(int i =0;i < seats.size();i++) {
			for(int j = 0; j < seats.size(); j++) {
				if(seats.get(j).getS_id().equals("pc"+param+i)) {
					String check = seats.get(j).getM_id();
					if(check == null) {
						seats.get(j).setM_id(" ");
						seats.get(j).setM_time(" ");
					}
					seatset.add(seats.get(j));
				}
			}
		}
		String json = new Gson().toJson(seatset);
		return json;
	}

	public ModelAndView SelectCate(String p_id , int snum) {
		mav = new ModelAndView();
		String jsonset = null;
		List<SeatBean> seats = sDao.selectAll(p_id);
		List<SeatBean> seatset = new ArrayList<SeatBean>();
		
		for(int i =0;i < seats.size();i++) {
			for(int j = 0; j < seats.size(); j++) {
				if(seats.get(j).getS_id().equals(i+"")) {
					String check = seats.get(j).getM_id();
					if(check == null) {
						seats.get(j).setM_id(" ");
						seats.get(j).setM_time(" ");
						seats.get(j).setM_birthday(" ");
					}
					check = seats.get(j).getS_spec();
					if(check == null) {
						jsonset = "스펙정보를 입력해주세요/스펙정보를 입력해주세요/스펙정보를 입력해주세요"; 
					}else {
						JsonParser parser = new JsonParser();
						JsonObject jsons = (JsonObject)parser.parse(seats.get(j).getS_spec());
						String a=null;
						String b=null;
						String c=null;
						try {
						 a = jsons.get("a").getAsString();
						}catch (Exception e) {
							System.out.println("a");
						}
						try {
							 b = jsons.get("b").getAsString();
							}catch (Exception e) {
								System.out.println("b");
							}
						try {
							 c = jsons.get("c").getAsString();
							}catch (Exception e) {
								System.out.println("c");
							}
						if(a!=null) {
							jsonset = a;
						}else {
							jsonset = "스펙정보를 입력해주세요";
						}
						if(b!=null) {
							jsonset += "/"+b;
						}else {
							jsonset += "/스펙정보를 입력해주세요";
						}
						if(c!=null) {
							jsonset += "/"+c;
						}else {
							jsonset += "/스펙정보를 입력해주세요";
						}
						seats.get(j).setS_spec(jsonset);
						}
					seatset.add(seats.get(j));
					
				}
			}
		}
		System.out.println(seatset.get(snum).getS_spec());
		mav.addObject("SeatList", seatset);
		mav.addObject("SeatSet", seatset.get(snum));
		mav.setViewName("SeatDetail");
		return mav;
	}
	public String SelectIdCate(String p_id , int snum) {
		mav = new ModelAndView();
		List<SeatBean> seats = sDao.selectAll(p_id);
		List<SeatBean> seatset = new ArrayList<SeatBean>();
		
		for(int i =0;i < seats.size();i++) {
			for(int j = 0; j < seats.size(); j++) {
				if(seats.get(j).getS_id().equals(i+"")) {
					String check = seats.get(j).getM_id();
					if(check == null) {
						seats.get(j).setM_id(" ");
						seats.get(j).setM_time(" ");
						seats.get(j).setM_birthday(" ");
					}
					check = seats.get(j).getS_spec();
					if(check == null) {
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("a", "스펙을 입력해주세요");
						map.put("b", "스펙을 입력해주세요");
						map.put("c", "스펙을 입력해주세요");
						String jsonset = new Gson().toJson(map);
						seats.get(j).setS_spec(jsonset);
					}else {
						HashMap<String, String> map = new HashMap<String, String>();
						JsonParser parser = new JsonParser();
						JsonObject jsons = (JsonObject)parser.parse(check);
						String a=null;
						String b=null;
						String c=null;
						try {
						 a = jsons.get("a").getAsString();
						}catch (Exception e) {
							System.out.println("a");
						}
						try {
							 b = jsons.get("b").getAsString();
							}catch (Exception e) {
								System.out.println("b");
							}
						try {
							 c = jsons.get("c").getAsString();
							}catch (Exception e) {
								System.out.println("c");
							}
						if(a != null ) {
							map.put("a",a);
						}else{
							map.put("a","스펙을 입력해주세요");
						}
						
						if(b != null ){
							map.put("b", b);
						}else {
							map.put("b","스펙을 입력해주세요");
						}
						
						if(c != null){
							map.put("c", c);
						}else {
							map.put("c","스펙을 입력해주세요");
						}
						
						String jsonset = new Gson().toJson(map);
						
						seats.get(j).setS_spec(jsonset);
					}
					seatset.add(seats.get(j));
					}	
				}
			}
		System.out.println(seatset.get(4).getS_spec());
		String json = new Gson().toJson(seatset.get(snum));
		
		return json;
	}

	public String UpdateSpec(String p_id, String snum, String spec, String param3) {
		HashMap<String, String> map = new HashMap<String, String>();
		param3 = param3.substring(0,param3.length()-1);
		p_id = "pc"+p_id+param3;
		String num = (snum.equals("1") ? "a" : (snum.equals("2") ? "b" : "c"));
		String orispec = sDao.selectSpec(p_id);
		if(orispec != null) {
			JsonParser parser = new JsonParser();
			JsonObject jsons = (JsonObject)parser.parse(orispec);
			String a=null;
			String b=null;
			String c=null;
			try {
			 a = jsons.get("a").getAsString();
			}catch (Exception e) {
				System.out.println("a");
			}
			try {
				 b = jsons.get("b").getAsString();
				}catch (Exception e) {
					System.out.println("b");
				}
			try {
				 c = jsons.get("c").getAsString();
				}catch (Exception e) {
					System.out.println("c");
				}
			if(a != null && !num.equals("a")) {
				map.put("a",a);
			}else if(num.equals("a")) {
				map.put("a",spec);
			}
			
			if(b != null && !num.equals("b")){
				map.put("b", b);
			}else if(num.equals("b")) {
				map.put("b",spec);
			}
			
			if(c != null && !num.equals("c")){
				map.put("c", c);
			}else if(num.equals("c")) {
				map.put("c",spec);
			}
		}else {
			map.put(num, spec);
		}
		String json = new Gson().toJson(map);
		map.put("p_id", p_id);
		map.put("spec", json);
		if(sDao.UpdateSpec(map)) {
			map = new HashMap<String, String>();
			map.put("success", "0");
		}else {
			map = new HashMap<String, String>();
			map.put("success", "1");
		}
		json = new Gson().toJson(map);
		return json;
	}

	public String SeatreserveChage(String s_id, String state) {
		s_id = s_id.substring(0,s_id.length()-1);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("s_id", s_id);
		if(state.equals("불가")) {
			map.put("stat", "가능");	
		}else {
			map.put("stat", "불가");
		}
		if(sDao.UpdateSeatReserve(map)) {
			map.clear();
			map.put("reser", sDao.SelectRe(s_id));
		}else {
			map.clear();
			map.put("reser", sDao.SelectRe(s_id));
		}
		String json = new Gson().toJson(map);
		
		return json;
	}

	
}
