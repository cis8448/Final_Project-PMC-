package com.pmc.final_project.service;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.Member;
import com.pmc.final_project.bean.PayMentDetail;
import com.pmc.final_project.bean.ProductBean;
import com.pmc.final_project.bean.SeatBean;
import com.pmc.final_project.dao.IFileDao;
import com.pmc.final_project.dao.IProductDao;
import com.pmc.final_project.util.FileProcess;
import com.pmc.final_project.util.Paging;


@Service
public class ProductManagement {
	
	private ModelAndView mav;
	
	@Autowired
	private IProductDao prDao;
	
	@Autowired
	IFileDao fDao;
	
	@Autowired
	FileProcess fileProc; 
	
	boolean f;
	
	@Autowired
	HttpSession session;
	
	public ModelAndView getProductList(Integer pageNum) {
		String p_id = (String)session.getAttribute("id");
		
		
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
	      
	      mav.addObject("product", product);
	      
	      
	      view = "ProductDetail";
	      mav.setViewName(view);
	      
	      return mav;
	}

	public String ProductCateInsert(String param) {
		String p_id = (String)session.getAttribute("id");
		String PC_ID = null;
		List<ProductBean> proList = prDao.selectcountcate(p_id);
		
		if(proList.size() !=0 ) {
		         int sizecheck = -1;
		         for(int i = 0; i < proList.size();i++) {
		             int num=Integer.parseInt(proList.get(i).getPc_id().substring(2+p_id.length(),
		            		 						proList.get(i).getPc_id().length()));
		            if(i == 0) {
		               sizecheck = num;
		               }else {
		               if(sizecheck < num){
		                  sizecheck = num;
		               }
		            }
		            
		         }
		         PC_ID = "PC"+p_id+(sizecheck+1);
		}else {
			PC_ID = "PC"+p_id +0;
		}
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("p_id", p_id);
		map.put("pc_id", PC_ID);
		map.put("name", param);
		if(prDao.dbsend(map)){
			map.put("ttt", "성공");
		}else{
			map.put("ttt", "실패");
		}
		String json = new Gson().toJson(map);
		
		return json;
	}

	public ModelAndView CateSearch(String pc_id, Integer pageNum) {
		String p_id = (String)session.getAttribute("id");
		
		
		
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

	public String ProductUpdate(MultipartHttpServletRequest multi) {
		String pc_id = multi.getParameter("pr_pc_id");
		String num = multi.getParameter("num");
		String mpr_id = null;
		HashMap<String, String> fMap = new HashMap<String, String>();
		List<ProductBean> prolist = prDao.getpcidList(multi.getParameter("pr_pc_id"));
		if(prolist.size() !=0) {
			 int sizecheck = -1;
	         for(int i = 0; i < prolist.size();i++) {
	             int num1=Integer.parseInt(prolist.get(i).getPr_id().substring(2+pc_id.length(), prolist.get(i).getPr_id().length()));
	            if(i == 0) {
	               sizecheck = num1;
	               }else {
	               if(sizecheck < num1){
	                  sizecheck = num1;
	               }
	            }
	         }
	         mpr_id = "PR"+pc_id + (sizecheck+1);
		}else {
			mpr_id = "PR"+multi.getParameter("pr_pc_id") + 0;
		}
		System.out.println(mpr_id);
		fMap.clear();
		if(num.equals("1")) {
			fMap=fileProc.ProductFile(multi, "hi");
		}else {
			fMap.put("sysFileName", "No_image.png");
		}
		
		
		
		fMap.put("pr_pc_id", multi.getParameter("pr_pc_id"));
		fMap.put("pr_id",mpr_id);
		fMap.put("pr_name", multi.getParameter("pr_name"));
		fMap.put("pr_price", multi.getParameter("pr_price"));
		fMap.put("pr_qty", multi.getParameter("pr_qty"));
		prDao.fileupdate(fMap);
		fMap.put("success", "1");
		String json = new Gson().toJson(fMap);
		return json;
	}

	public ModelAndView ProductAdd(Integer pageNum) {
		
		mav = new ModelAndView();
		String view = null;
		List<ProductBean> bpList = null;
		
	    String p_id = (String)session.getAttribute("id");
	  	
		
		int num = (pageNum == null) ? 1 : pageNum;
		
		bpList = prDao.getPrList(p_id);
		
		mav.addObject("bpList", bpList);
		view = "ProductAdd";
		mav.setViewName(view);
		
		return mav;
	}

	public ModelAndView ProductUpdating(String pr_id) {
		String p_id = (String)session.getAttribute("id");
		  mav = new ModelAndView();
	      String view = null;
	      ProductBean product = prDao.ProductDetail(pr_id);
	      List<ProductBean> catelist = prDao.getPrList(p_id);
	      mav.addObject("product", product);
	      mav.addObject("cateList", catelist);
	      mav.setViewName("ProductUpdate");
		return mav;
	}

	public String ProductUp(MultipartHttpServletRequest mpre) {
		String num = mpre.getParameter("num");
		String f = null;
		Map<String, String> fMap = new HashMap<String, String>();
		if(num.equals("1")) {
			fMap=fileProc.Productup(mpre, "hi");
		}else {
			ProductBean list = prDao.selectimg(mpre.getParameter("pr_id"));
			fMap.put("pr_img", list.getPr_img());
		}
		
		fMap.put("pr_pc_id", mpre.getParameter("pr_pc_id"));
		fMap.put("pr_id",mpre.getParameter("pr_id"));
		fMap.put("pr_name", mpre.getParameter("pr_name"));
		fMap.put("pr_price", mpre.getParameter("pr_price"));
		fMap.put("pr_qty", mpre.getParameter("pr_qty"));
		
		prDao.ProductUpdate(fMap);
		
		fMap.clear();
		fMap.put("success", "1");
		String json = new Gson().toJson(fMap);
				
		return json;
	}

	public ModelAndView ProductDelete(String pr_id) {
		mav = new ModelAndView();
		if(prDao.ProductDelete(pr_id)) {
			mav.addObject("success","0");
		}else {
			mav.addObject("success","1");
		}
		mav.setViewName("redirect:./Product");
		return mav;
	}

	public String ProductCateUpdate(String pc_id, String pc_name) {
		String json = null;
		HashMap<String, String > map = new HashMap<String, String>();
		map.put("pc_id", pc_id);
		map.put("pc_name", pc_name);
		if(prDao.CateUpdate(map)) {
			map.put("success", "0");
			json = new Gson().toJson(map);
		}else {
			map.put("success", "1");
			json = new Gson().toJson(map);
		}
		return json;
	}

	public String ProductCateDelete(String pc_id) {
		String json = null;
		HashMap<String, String> map = new HashMap<String, String>();
		if(prDao.selectcatechildcount(pc_id) == 0) {
			f=prDao.CateDelete(pc_id);
		}else {
			prDao.ProductDeletes(pc_id);
			f=prDao.CateDelete(pc_id);
		}
		if(f) {
			map.put("success", "0");
		}else {
			map.put("success", "1");
		}
		json = new Gson().toJson(map);
		return json;
	}
	
	
	public String ProductSearch(String res) {
		
		String id=(String)session.getAttribute("id");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("p_id", id);
		map.put("res", "%"+res+"%");
		
		System.out.println(res);
		
		List<ProductBean> sproduct = prDao.productSearch(map);
		
		String json = new Gson().toJson(sproduct);
		
		return json;
		
	}
}
	

	


