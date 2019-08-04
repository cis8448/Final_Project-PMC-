package com.pmc.final_project.dao;

import java.util.List;

import com.pmc.final_project.bean.PayMentDetail;

public interface IPayDao {

	public List<PayMentDetail> getPayList();

	public List<PayMentDetail> getmemberPaylist(String u_m_id);

	public int getmemberPayCount(String u_m_id);

}
