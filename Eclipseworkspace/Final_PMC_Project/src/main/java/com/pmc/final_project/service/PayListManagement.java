package com.pmc.final_project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.PayMentDetail;
import com.pmc.final_project.bean.ProductCate;
import com.pmc.final_project.dao.IPayDao;
import com.pmc.final_project.dao.IProductDao;
import com.pmc.final_project.util.Paging;

@Service
public class PayListManagement {

	private ModelAndView mav;
	
	@Autowired
	private IPayDao payDao;
	
	
	@Autowired
	private HttpSession session;
	
	
	public ModelAndView getPayList(Integer ProductNum) {
		mav = new ModelAndView();
		String view = null;
		List<PayMentDetail> pList = null;
		
		
		int num = (ProductNum == null) ? 1 : ProductNum;
		
		pList = payDao.getPayList();
		
		mav.addObject("pList" ,pList);
		//mav.addObject("paypaging" , getPayPaging(num));
		view = "MemberPayList";
		mav.setViewName(view);
		
		return mav;
		
	}
	
	public String PayDate(String u_start) {
		mav = new ModelAndView();
		String view = null;
		System.out.println(u_start + "출력");
		
		String id=(String)session.getAttribute("u_start");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("u_start", u_start);
		Map<Object, Object> fmap = new HashMap<Object, Object>();
		
		String json = null;
		System.out.println();
		System.out.println("드루와");
		if(payDao.PayDate(map)) {
			System.out.println("드루와2");
			fmap.put("cnt",1);
			
		}else {
			System.out.println("실패");
		}
		json = new Gson().toJson(fmap);
		mav.setViewName(view);
		return json;
			
	}
	



	public ModelAndView getmemberPayList(Integer pageNum) {
		mav = new ModelAndView();
		String view = null;
		List<PayMentDetail> mpList = null;
		
		String u_m_id = (String)session.getAttribute("m_id");
		
		int num = (pageNum == null) ? 1 : pageNum;
		
		System.out.println(u_m_id+"첫번쨰");
		
		mpList = payDao.getmemberPaylist(u_m_id);
		System.out.println(mpList.get(0).getU_m_id());
		System.out.println(mpList.get(0).getU_start());
		
		mav.addObject("mpList", mpList);

		mav.addObject("memberpayPaging", getmemberPayPaging(num));
		
		view = "MemberPayCheck";
		mav.setViewName(view);
		session.removeAttribute("m_id");
		return mav;
	}


	private String getmemberPayPaging(int num) {
		String u_m_id = (String)session.getAttribute("m_id");
		System.out.println(u_m_id+"두번쨰");
		int maxNum = payDao.getmemberPayCount(u_m_id);
		//페이지 당 회원 수
		int listCnt = 10;
		//그룹당 페이지 수
		int pageCnt = 3;
		//게시판이 여러 종류가 있다면 
		String memberpayName = "MemberPayCheck";
		Paging memberpayPaging = 
			new Paging(maxNum, num, listCnt, 
						pageCnt, memberpayName);
						
		return memberpayPaging.makeHtmlpaging();
	}


//	private String getPayPaging(int num) {
//		int maxNum = payDao.getPayList();
//		
//		int listCnt = 10;
//		int pageCnt = 5;
//		String PayListName = "MemberPayList";
//		Paging paypaging = new Paging(maxNum, num, listCnt, pageCnt, PayListName);
//		return paypaging.makeHtmlpaging();
//	}
	
	
	
}
