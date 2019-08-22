package com.pmc.final_project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.UseLogBean;

public interface IUseLogDao {

	List<UseLogBean> getmemberuseLog(String m_id);

	int getUseLogCount(String m_id);

	boolean InsertReserve(Map map);

	boolean reserveDelete(Map map);

//	ArrayList<UseLogBean> Getuselog(String id);

	List<UseLogBean> SelectRE(String p_id);


}
