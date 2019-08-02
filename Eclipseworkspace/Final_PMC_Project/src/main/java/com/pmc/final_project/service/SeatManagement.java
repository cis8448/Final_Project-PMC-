package com.pmc.final_project.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
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
		 
		 while(params.hasMoreElements()){
		 String names = (String)params.nextElement();
		 if(names.equals("p_id")) {
			 p_id = multi.getParameter(names);
		 }else if(names.equals("num")){
			 num = multi.getParameter(names);
		 }else{
			seatv.add(multi.getParameter(names));
		 }
		 }
		 //DB에서 해당 pc방 좌석 갯수 가져로기
		 int datacnt = sDao.selectCount(p_id);
		 //DB값과 requst값이 같을때 처리
		 if(seatv.size()   == datacnt) {
			 System.out.println("좌석은 넘어감");
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
		 //파일업로드 
		 if(num.equals("1")) {
			 String root = multi.getSession().
						getServletContext().getRealPath("/");
			 
				String path = root + "resources/"+p_id;
				
				File dir = new File(path);
				if(!dir.isDirectory()) {
					dir.mkdir();
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
					fMap.put("sysFileName", sysName);

					try {
						mf.transferTo(new File(path + sysName));
						//파일 데이터 저장
						f = fDao.fileInsert(fMap);
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
		mav.addObject("Slist", seats);
		FileBean fileroot = fDao.SelectFile(p_id);
		mav.addObject("Sfile", fileroot);
		mav.setViewName(View);

		return mav;
	}
	

	
}
