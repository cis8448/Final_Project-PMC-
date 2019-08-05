package com.pmc.final_project.dao;

import java.util.List;

import com.pmc.final_project.bean.UseLogBean;

public interface IUseLogDao {

	List<UseLogBean> getmemberuseLog(String m_id);

	int getUseLogCount(String m_id);


}
