package com.pmc.final_project.dao;

import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.Member;

public interface IMemberDao {

	public List<Member> getmemberAllList();

	public int getMemberCount();

	public Member getmemberInfo(String m_id);

	public boolean memberTimeAdd(Map<String, String> map);



}
