package com.pmc.final_project.service;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.ProductBean;
import com.pmc.final_project.dao.IProductDao;
import com.pmc.final_project.util.Paging;


@Service
public class ProductManagement {
	
	private ModelAndView mav;
	
	@Autowired
	private IProductDao prDao;
	
	@Autowired
	HttpSession session;
	
	public ModelAndView getProductList(Integer pageNum) {
		String p_id = (String)session.getAttribute("id");
		String maxcount = prDao.selectcountcate(p_id);
		
		
		mav = new ModelAndView();
		String view = null;
		List<ProductBean> prList = null;
		List<ProductBean> cateList = null;
		//pageNum이 널이면(로그인 한 후) 첫페이지를 보이도록.
		int num = (pageNum == null) ? 1 : pageNum;
		String size = p_id.length()+"";
		HashMap<String , String> map =  new HashMap<String, String>();
		map.put("size", size);
		map.put("p_id", p_id);
		prList = prDao.getProductList(map);
		cateList = prDao.getCateList(p_id);
		
		mav.addObject("prList", prList);
		mav.addObject("catelist", cateList);
		
		mav.addObject("paging", getPaging(num));
		view = "Product";
		mav.setViewName(view);
		return mav;
	}

	private String getPaging(int num) {
		//전체 글수
		int maxNum = prDao.getProductCount();
		//페이지 당 글수
		int listCnt = 10;
		//그룹당 페이지 수
		int pageCnt = 5;
		//게시판이 여러 종류가 있다면 
		String productName = "product";
		Paging propaging = 
				new Paging(maxNum, num, listCnt, 
						pageCnt, productName);
		
		return propaging.makeHtmlpaging();
	}

	
	

	public ModelAndView ProductDetail(String pr_id) {
		  mav = new ModelAndView();
	      String view = null;
	      
	      ProductBean product = prDao.ProductDetail(pr_id);
	      session.setAttribute("pr_id", product.getPr_id());
	      
	      mav.addObject("product", product);
	      
	      view = "ProductDetail";
	      mav.setViewName(view);
	      
	      return mav;
	}

	public String ProductCateInsert(String param) {
		String p_id = (String)session.getAttribute("id");
		
		String maxcount = prDao.selectcountcate(p_id);
		String pc_id = null;
		 if(maxcount != null) {
			 int result = Integer.parseInt(maxcount.substring(p_id.length()+2));
			 pc_id = "PC"+p_id+(result+1);
			 System.out.println(maxcount);
		 }else {
			 pc_id = "PC"+p_id+1;
		 }
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("p_id", p_id);
		map.put("pc_id", pc_id);
		map.put("name", param);
		if(prDao.dbsend(map)){
			map.clear();
			map.put("ttt", "성공");
		}else{
			map.clear();
			map.put("ttt", "실패");
		}
		String json = new Gson().toJson(map);
		
		return json;
	}

	public ModelAndView CateSearch(String pc_id, Integer pageNum) {
		String p_id = (String)session.getAttribute("id");
		String maxcount = prDao.selectcountcate(p_id);
		
		
		mav = new ModelAndView();
		String view = null;
		List<ProductBean> prList = null;
		List<ProductBean> cateList = null;
		//pageNum이 널이면(로그인 한 후) 첫페이지를 보이도록.
		int num = (pageNum == null) ? 1 : pageNum;
		
		prList = prDao.getpcidList(pc_id);
		cateList = prDao.getCateList(p_id);
		
		if(prList.size() > 0) {
		for(int i = 0; i < cateList.size(); i++) {
			if(cateList.get(i).getPc_id().equals(prList.get(0).getPc_id())) {
				for(int j = 0; j < prList.size();j++) {
					prList.get(j).setPc_name(cateList.get(i).getPc_name());
					}
				}
			}
		
		
		mav.addObject("prList", prList);
		}
		mav.addObject("catelist", cateList);
		
		mav.addObject("paging", getPaging(num));
		view = "Product";
		mav.setViewName(view);
		
		return mav;
	}
	

	

}
