package com.pmc.final_project;

import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
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
	

	
	@RequestMapping(value ="/ProductAdd")
	public ModelAndView ProductAdd(Integer pageNum) {
		
		mav = prm.ProductAdd(pageNum);
		
		
		return mav;   
	}
	
	@RequestMapping(value = "/ProductCateAdd")
	public String ProductCateAdd() {
		 
		return "ProductCateAdd";   
	}
	
	@RequestMapping(value = "/ProductDetail")
	public ModelAndView ProductDetail(@RequestParam("pr_id") String pr_id) {
		
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
	@RequestMapping(value = "/productcateupdate", method = RequestMethod.POST, produces = "application/text; charset=utf8")   
	public @ResponseBody String productcateupdate(@RequestParam("pc_id") String pc_id, @RequestParam("pc_name") String pc_name) {
		
		String json = prm.ProductCateUpdate(pc_id,pc_name);
		
		return json; 
	}
	@RequestMapping(value = "/productcateDelete", method = RequestMethod.POST, produces = "application/text; charset=utf8")   
	public @ResponseBody String productcateDelete(@RequestBody String pc_id) {
		
		String json = prm.ProductCateDelete(pc_id);
		
		return json; 
	}
	@RequestMapping(value = "/productInsert")
	public @ResponseBody String productInsert(MultipartHttpServletRequest multi) {
		String json = prm.ProductUpdate(multi);
		
		return json;
	}
	
	@RequestMapping(value = "/ProductUpdate")
	public ModelAndView ProductUpdate(@RequestParam("pr_id") String pr_id) {
		
		 mav = prm.ProductUpdating(pr_id);
		 
		return mav;   
	}
	@RequestMapping(value = "/productUp")
	public @ResponseBody String productUp(MultipartHttpServletRequest mpre) {
		String json = prm.ProductUp(mpre);
		
		return json;
	}
	@RequestMapping(value = "/productDelete")
	public ModelAndView productDelete(@RequestParam("pr_id") String pr_id) {
		mav = prm.ProductDelete(pr_id);
		
		return mav;
	}

	@RequestMapping(value = "/cateSearch",produces = "application/text; charset=utf8")
	public @ResponseBody String cateSearch(@RequestParam("id") String id) {
		String json = prm.mCateSearch(id);
		
		return json;
	}
	@RequestMapping(value = "/mProduct",produces = "application/text; charset=utf8")
	public @ResponseBody String Product() {
		String json = prm.mProduct();
		return json;
	}
}
