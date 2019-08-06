package com.pmc.final_project.dao;

import java.util.HashMap;
import java.util.List;

import com.pmc.final_project.bean.ProductBean;
import com.pmc.final_project.bean.ProductCate;

public interface IProductDao {

	List<ProductBean> getProductList(String p_id);

	int getProductCount();

	ProductBean ProductDetail(String pr_id);

	public String selectcountcate(String p_id);

	boolean dbsend(HashMap<String, String> map);

	String InsertRe(String p_id);

	List<ProductCate> getCateList(String p_id);


}
