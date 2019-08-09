package com.pmc.final_project.service;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.bean.PcRoomNoticeBean;
import com.pmc.final_project.dao.INotice;
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
	private INotice nDao;

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
		
		pDao.negative(id);

		map.put("cnt",count);
		
		json = new Gson().toJson(map);
		return json;
	}

	public ModelAndView OM_PCDetail(String id) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		PcRoomBean pr = new PcRoomBean();
		String view = null;
		String cate = null;
		String array[] = id.split("/");
		id=array[0];
		cate = array[1];
		if(cate.equals("1")) {
			pr=pDao.approvalSelect(id);
		}else {
			pr=pDao.getMemberInfo(id);
		}
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

	public ModelAndView OM_Approvalx(Integer pageNum) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String view = null;

		List<PcRoomBean> sbpclist = null;
		int num = (pageNum == null) ? 1 : pageNum;

		sbpclist =pDao.selectAll2(num);
		mav.addObject("sbpclist", sbpclist);
		mav.addObject("paging", getPaging(num));

		view = "OM_Approvalx";
		mav.setViewName(view);
		return mav;
	}

	public String approvalx(String id) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String json = null;
		int count = 0;
		Map<Object,Object> map = new HashMap<Object, Object>();
		String array[] = id.split("/");
		array[1] = array[1].equals("3")? "2":"3";
		map.put("id",array[0]);
		map.put("holiday", array[1]);
		pDao.approvalx(map);
		map.remove("id");
		json = new Gson().toJson(map);
		return json;
	}

	public ModelAndView OM_Notice(Integer pageNum, String cate) {
		mav = new ModelAndView();
		String view = null;

		List<PcRoomNoticeBean> nList = null;
		int num = (pageNum == null) ? 1 : pageNum;
		Map<String, String> map = new HashMap<String, String>();
		map.put("cate",cate);
		map.put("num",num+"");

		nList =nDao.OM_Notice(map);
		mav.addObject("nList", nList);
		mav.addObject("paging", getPaging(num));

		view = "OM_Notice";

		mav.setViewName(view);

		return mav;
	}

	public ModelAndView OM_Service(Integer pageNum, String cate) {
		mav = new ModelAndView();
		String view = null;

		List<PcRoomNoticeBean> nList = null;
		int num = (pageNum == null) ? 1 : pageNum;
		Map<String, String> map = new HashMap<String, String>();
		map.put("cate",cate);
		map.put("num",num+"");

		nList =nDao.OM_Service(map);
		mav.addObject("nList", nList);
		mav.addObject("paging", getPaging(num));

		view = "OM_Service";

		mav.setViewName(view);

		return mav;
	}

	public ModelAndView OM_NoticeInfo(String no_num) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String view = null;

		PcRoomNoticeBean pr = nDao.OM_NoticeInfo(no_num);
		mav.addObject("OMnotice", pr);
		view = "OM_NoticeInfo";
		mav.setViewName(view);

		return mav;
	}

	public ModelAndView OM_ServiceInfo(String no_num) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String view = null;

		PcRoomNoticeBean pr = nDao.OM_ServiceInfo(no_num);
		mav.addObject("OMservice", pr);
		view = "OM_ServiceInfo";
		mav.setViewName(view);

		return mav;
	}

	public ModelAndView OM_NInsert(PcRoomNoticeBean pb) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String view = null;
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
					
		Date time = new Date();
				
		String time1 = format1.format(time);
		pb.setNo_date(time1);
		pb.setNo_p_id((String)session.getAttribute("id"));
		nDao.OM_NInsert(pb);	
		
		mav.addObject("insert",1);
		
		view = "redirect:/OM_Notice?cate=0";
		mav.setViewName(view);
		
		return mav;
	}



}
