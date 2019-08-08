package com.pmc.final_project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.ProductBean;

public interface IProductDao {

	List<ProductBean> getProductList(HashMap<String, String> map);

	int getProductCount();

	ProductBean ProductDetail(String pr_id);

	public List<ProductBean> selectcountcate(String p_id);

	boolean dbsend(HashMap<String, String> map);

	String InsertRe(String p_id);

	List<ProductBean> getCateList(String p_id);

	List<ProductBean> getpcidList(String pc_id);

	boolean fileupdate(Map<String, String> fMap);

	List<ProductBean> getPrList(String p_id);

	void ProductUpdate(Map<String, String> fMap);

	ProductBean selectimg(String parameter);

	boolean ProductDelete(String pr_id);

	boolean CateUpdate(HashMap<String, String> map);

	int selectcatechildcount(String pc_id);

	boolean CateDelete(String pc_id);

	void ProductDeletes(String pc_id);

	List<ProductBean> productSearch(Map<String, String> map);



}
