package com.pmc.final_project.service;

import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.dao.IPcRoom;
import com.pmc.final_project.util.FileProcess;
import com.pmc.final_project.util.Paging;

@Service
public class ManagerManagement {
	private ModelAndView mav;

	@Autowired
	private IPcRoom pDao;

	@Autowired
	private HttpSession session;

	@Autowired
	FileProcess fileProc;


	public ModelAndView OM_Approval(Integer pageNum) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String view = null;

		List<PcRoomBean> sbpclist = null;
		int num = (pageNum == null) ? 1 : pageNum;

		sbpclist =pDao.selectAll(num);
		mav.addObject("sbpclist", sbpclist);
		mav.addObject("paging", getPaging(num));
		view = "OM_Approval";
		mav.setViewName(view);

		return mav;
	}

	private String getPaging(int num) {
		//전체 글수
		int maxNum = pDao.getSBPCCount();
		//페이지 당 글수
		int listCnt = 10;
		//그룹당 페이지 수
		int pageCnt = 2;
		//게시판이 여러 종류가 있다면 
		String boardName = "OM_Approval";
		Paging paging = 
				new Paging(maxNum, num, listCnt, 
						pageCnt, boardName);

		return paging.makeHtmlpaging();
	}

	public String approval(String id) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();

		String json = null;
		int count = 0;
		Map<Object,Object> map = new HashMap<Object, Object>();
		id=id.replace("=","");
		System.out.println("마지막 아이디"+id+"이것뭐냐");


		PcRoomBean pr =pDao.approvalSelect(id);
		System.out.println(pr.getP_id());
		System.out.println(pr.getP_pass());
		pr.setP_id(pr.getP_id());
		pr.setP_name(pr.getP_name());
		pr.setP_phone(pr.getP_phone());
		pr.setP_email(pr.getP_email());
		pr.setP_dong(pr.getP_dong());
		pr.setP_addr(pr.getP_addr());
		pr.setP_holiday(pr.getP_holiday());
		pr.setP_sido(pr.getP_sido());
		pr.setP_gugun(pr.getP_gugun());
		pr.setP_pass(pr.getP_pass());

		if(pDao.approvalInsert(pr)) {
			pDao.approvalDelete(id);
			count=1;
		}else {
			count=0;
		}


		map.put("cnt",count);

		json = new Gson().toJson(map);
		mav.setViewName("OM_Approval");
		return json;
	}

	public String negative(String id) {
		// TODO Auto-generated method stub
		String json = null;
		int count = 0;
		Map<Object,Object> map = new HashMap<Object, Object>();
		id=id.replace("=","");

		pDao.approvalDelete(id);

		map.put("cnt",count);
		json = new Gson().toJson(map);
		return json;
	}

	public ModelAndView OM_PCDetail(String id) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String view = null;

		PcRoomBean pr=pDao.approvalSelect(id);
		System.out.println(pr.getP_id());
		//파일 처리
		List<PcRoomBean> bfList = pDao.getFileList(id);
		mav.addObject("bfList",bfList);
		mav.addObject("pcr",pr);
		
		view = "OM_PCDetail";
		mav.setViewName(view);

		return mav;
	}
	//파일 다운로드 서비스  제공 메소드
	public void downLoad(Map<String, Object> params) throws Exception {
		String oriFileName = (String)params.get("oriFileName");
		String sysFileName = (String)params.get("sysFileName");
		String root = (String)params.get("root");
		String path = root + "resources/file/"+sysFileName;

		HttpServletResponse resp= (HttpServletResponse)params.get("resp");

		fileProc.downFile(path,sysFileName,resp);
	}



}
