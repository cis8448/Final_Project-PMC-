  
package com.pmc.final_project.dao;

import java.util.List;

import com.pmc.final_project.bean.Member;

public interface IMemberDao {

	public List<Member> getmemberAllList(int num);

	public int getMemberCount();

	public Member getmemberInfo(String m_id);



}
