package com.pmc.final_project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.PayMentDetail;
import com.pmc.final_project.bean.Paybean;
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
		
	    String p_id = (String)session.getAttribute("id");
	  	
		
		int num = (ProductNum == null) ? 1 : ProductNum;
		
		pList = payDao.getPayList(p_id);
		
		mav.addObject("pList" ,pList);
//		mav.addObject("paypaging" , getPayPaging(num));
		view = "MemberPayList";
		mav.setViewName(view);
		
		return mav;
		
	}
	
	

	 public ModelAndView getCateList(Integer CateNum) {
	      mav = new ModelAndView();
	      String view = null;
	      List<PayMentDetail> cateList = null;
	      
	      String p_id = (String)session.getAttribute("id");
	      
	      int num = (CateNum == null) ? 1 : CateNum;
	      
	      cateList = payDao.getPayList(p_id);
	      
	      mav.addObject("cateList", cateList);
	      view = "CatePayList";
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
	



	public ModelAndView getmemberPayList(Integer pageNum, String m_id) {
		mav = new ModelAndView();
		String view = null;
		List<PayMentDetail> mpList = null;	
		int num = (pageNum == null) ? 1 : pageNum;
		
		System.out.println(m_id);

		mpList = payDao.getmemberPaylist(m_id);

		mav.addObject("mpList", mpList);
		mav.addObject("memberpayPaging", getmemberPayPaging(num, m_id));
		
		view = "MemberPayCheck";
		mav.setViewName(view);
		return mav;
	}


	private String getmemberPayPaging(int num, String m_id) {

		System.out.println(m_id+"두번쨰");
		int maxNum = payDao.getmemberPayCount(m_id);
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



	public String casearch(String selcate) {
		
		List<PayMentDetail> pmList = payDao.cateSearch(selcate);
		String json = new Gson().toJson(pmList);
		
		
		return json;
	}



	public String datesearch(String plus) {
		
		String p_id = (String)session.getAttribute("id");
		
		System.out.println(p_id);
		System.out.println(plus);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("p_id", p_id);
		map.put("plus", plus);
		List<PayMentDetail> payList = payDao.datesearch(map);
		String json = new Gson().toJson(payList);
		
		return json;
	}



	public String insertPay(String id, ArrayList<Paybean> payBean) {
		String usecode  = payDao.selectUselog(id);
		for(int i = 0 ; i < payBean.size();i++) {
			payBean.get(i).setPl_u_code(usecode);
			payDao.insertPay(payBean.get(i));
		}
		
		return "1";
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
