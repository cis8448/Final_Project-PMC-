package com.pmc.final_project.dao;

import java.util.List;

import com.pmc.final_project.bean.ProductBean;

public interface IProductDao {

	List<ProductBean> getProductList();

	int getProductCount();


}
