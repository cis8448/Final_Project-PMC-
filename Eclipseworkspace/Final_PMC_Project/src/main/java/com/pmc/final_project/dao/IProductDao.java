package com.pmc.final_project.dao;

import java.util.HashMap;
import java.util.List;

import com.pmc.final_project.bean.ProductBean;

public interface IProductDao {

	List<ProductBean> getProductList(HashMap<String, String> map);

	int getProductCount();

	ProductBean ProductDetail(String pr_id);

	public String selectcountcate(String p_id);

	boolean dbsend(HashMap<String, String> map);

	String InsertRe(String p_id);

	List<ProductBean> getCateList(String p_id);

	List<ProductBean> getpcidList(String pc_id);


}
