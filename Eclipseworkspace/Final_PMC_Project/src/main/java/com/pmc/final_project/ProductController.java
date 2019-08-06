package com.pmc.final_project;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.bean.ProductBean;
import com.pmc.final_project.dao.IPcRoom;
import com.pmc.final_project.dao.IProductDao;
import com.pmc.final_project.service.PcroomManagement;
import com.pmc.final_project.service.ProductManagement;

@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	private ModelAndView mav;
	
	@Autowired
	ProductManagement prm;
	
	@Autowired
	private HttpSession session;
	

	
	@RequestMapping(value = "/ProductAdd")
	public String ProductAdd() {
		
		return "ProductAdd";   
	}
	
	@RequestMapping(value = "/ProductCateAdd")
	public String ProductCateAdd() {
		 
		return "ProductCateAdd";   
	}
	
	@RequestMapping(value = "/ProductDetail")
	public ModelAndView ProductDetail(String pr_id) {
		
		 mav = prm.ProductDetail(pr_id);
		 
		return mav;   
	}
	
	@RequestMapping(value = "/Product")   //db 검색 하여 목록 생성
	public ModelAndView ProductList(Integer pageNum) {

		mav = prm.getProductList(pageNum);
		
		
		return mav;   
	}
	
	@RequestMapping(value = "/cateinfo")   //db 검색 하여 목록 생성
	public ModelAndView ProductList(@RequestParam("pc_id") String pc_id) {

		mav = prm.CateSearch(pc_id, null);
		
		return mav;
	}
	
	@RequestMapping(value = "/productcateadd", method = RequestMethod.POST, produces = "application/text; charset=utf8")   
	public @ResponseBody String productcateadd(@RequestBody String param) {
		
		String json = prm.ProductCateInsert(param);
		
		return json; 
	}
}
