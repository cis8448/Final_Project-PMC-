package com.pmc.final_project.dao;

import com.pmc.final_project.bean.PcRoomBean;

public interface IPcRoom {

	public boolean JSPSignUp(PcRoomBean pr);

	public String getSecurityPwd(String p_id);

	public PcRoomBean getMemberInfo(String p_id);

	public int PCIdCheck(String userid);

}
