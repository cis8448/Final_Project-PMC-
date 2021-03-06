package com.pmc.final_project.dao;

import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.Member;

public interface IMemberDao {

	public List<Member> getmemberAllList(String p_id);

	public int getMemberCount(String id);

	public Member getmemberInfo(Map<String, String> map);

	public boolean memberTimeAdd(Map<String, String> map);

	public String TimeSelect(Map<String, String> map);

	public List<Member> memberSearch(Map<String, String> map);

	public List<Member> getOMmemberAllList();

	public int getOMmemberCount();

	public Member getOMmemberInfo(Map<String, String> map);

	public List<Member> OMMemberSearch(String res);

	public int getBlockSearch(Map<String, String> map);

	public boolean BlockInsert(Map<String, String> map);

	public boolean BlockDelete(Map<String, String> map);

	public int SelBlock(Map<String, String> map);

	public boolean MyInfoUpdate(Member member);

	

	




}
