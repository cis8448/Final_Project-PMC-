package com.pmc.final_project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.bean.ProductCate;
import com.pmc.final_project.dao.ICateDao;

@Service
public class CateListManagement {

	private ModelAndView mav;
	
	@Autowired
	private ICateDao cateDao;
	
	@Autowired
	private HttpSession session;
	
	public ModelAndView getCateList(Integer CateNum) {
		mav = new ModelAndView();
		String view = null;
		List<ProductCate> cateList = null;
		
		int num = (CateNum == null) ? 1 : CateNum;
		
		cateList = cateDao.getCateList();
		
		mav.addObject("cateList", cateList);
		view = "CatePayList";
		mav.setViewName(view);
		
		return mav;
	}
}
