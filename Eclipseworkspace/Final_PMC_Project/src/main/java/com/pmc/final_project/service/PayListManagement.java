package com.pmc.final_project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.bean.PayMentDetail;
import com.pmc.final_project.dao.IPayDao;

@Service
public class PayListManagement {

	private ModelAndView mav;
	
	@Autowired
	private IPayDao payDao;
	
	@Autowired
	HttpSession session;
	
	
	public ModelAndView getPayList(Integer ProductNum) {
		mav = new ModelAndView();
		String view = null;
		List<PayMentDetail> pList = null;
		int num = (ProductNum == null) ? 1 : ProductNum;
		
		pList = payDao.getPayList(num);
		
		mav.addObject("pList" ,pList);
		//mav.addObject("paging" , getPaging(num));
		view = "PayList";
		mav.setViewName(view);
		
		return mav;
		
	}


//	private String getPaging(int num) {
//		int maxNum = payDao.getPayList();
//		
//		int listCnt = 10;
//		int pageCnt = 5;
//		String PayListName = "PayList";
//		paging paging = new paging(maxNum, num, listCnt, pageCnt, PayListName);
//		return paging.makeHtmlpaging;
//	}
	
	
	
	
}
