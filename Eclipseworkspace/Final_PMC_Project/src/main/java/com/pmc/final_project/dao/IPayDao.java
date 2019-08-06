package com.pmc.final_project.dao;

import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.PayMentDetail;

public interface IPayDao {

	public List<PayMentDetail> getPayList(String p_id);

	public List<PayMentDetail> getmemberPaylist(String u_m_id);

	public int getmemberPayCount(String u_m_id);

	public int accept(String userid);

	public boolean PayDate(Map<String, String> map);

	public List<PayMentDetail> cateSearch(String pc_name);

	public List<PayMentDetail> datesearch(Map<String, String> map);

	




}
