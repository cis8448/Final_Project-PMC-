package com.pmc.final_project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.PayMentDetail;
import com.pmc.final_project.bean.Paybean;

public interface IPayDao {

	public List<PayMentDetail> getPayList(String p_id);

	public List<PayMentDetail> getmemberPaylist(String m_id);

	public int getmemberPayCount(String m_id);

	public int accept(String userid);

	public boolean PayDate(Map<String, String> map);

	public List<PayMentDetail> cateSearch(String selcate);

	public List<PayMentDetail> datesearch(Map<String, String> map);

	public String selectUselog(String id);

	public void insertPay(Paybean paybean);

	public List<String> selectCate(String p_id);

	public ArrayList<PayMentDetail> SelectPayList1(String id);

	


	




}
