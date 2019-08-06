  
package com.pmc.final_project.dao;

import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.Member;

public interface IMemberDao {

	public List<Member> getmemberAllList(String p_id);

	public int getMemberCount(String id);

	public Member getmemberInfo(Integer m_id);

	public boolean memberTimeAdd(Map<String, String> map);

	public String TimeSelect(Map<String, String> map);

	public List<Member> memberSearch(Map<String, String> map);



}
