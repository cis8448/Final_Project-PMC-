package com.pmc.final_project.dao;

import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.PayMentDetail;


public interface IPayDao {

	public List<PayMentDetail> getPayList();

	public int accept(String userid);

	public boolean PayDate(Map<String, String> map);

	

}
