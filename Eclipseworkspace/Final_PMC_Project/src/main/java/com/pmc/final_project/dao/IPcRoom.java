package com.pmc.final_project.dao;

import java.util.Map;

import com.pmc.final_project.bean.PcRoomBean;

public interface IPcRoom {

	public boolean JSPSignUp(PcRoomBean pr);

	public String getSecurityPwd(String id);

	public PcRoomBean getMemberInfo(String id);

	public int PCIdCheck(String userid);

	public String idsearch(PcRoomBean pr);

	public boolean pwsearch(Map<String,String> map);

	

}
