package com.pmc.final_project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
		mav = new ModelAndView();
		String view = null;
		List<ProductBean> prList = null;
		//pageNum이 널이면(로그인 한 후) 첫페이지를 보이도록.
		int num = (pageNum == null) ? 1 : pageNum;
		
		prList = prDao.getProductList();
		
		mav.addObject("prList", prList);
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
	      session.setAttribute("m_id", product.getPr_id());
	      
	      mav.addObject("product", product);
	      
	      view = "ProductDetail";
	      mav.setViewName(view);
	      
	      return mav;
	}
	
//	public ModelAndView producAdd(ProductBean product) {
//		mav = new ModelAndView();
//		String view = null;
//		
//		product.setPr_id(session.getAttribute("id").toString());
//		
//		if(prDao.productInsert(product)) {
//			view = "redirect:ProductList";
//		}
//		else {
//			view = "ProductAdd";
//		}
//		
//		mav.setViewName(view);
//		
//		return mav;
//	}
	

}
