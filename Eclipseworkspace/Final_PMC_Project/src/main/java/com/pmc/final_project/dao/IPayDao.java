package com.pmc.final_project.dao;

import java.util.List;

import com.pmc.final_project.bean.PayMentDetail;

public interface IPayDao {

	List<PayMentDetail> getPayList(int num);

}
