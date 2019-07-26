package com.pmc.final_project_dao;

import com.pmc.final_project_bean.Member;

public interface IMemberDao {
	public boolean memberInsert(Member mb);
	//로그인용 메소드, 멤버정보 읽어오기 메소드 등등.. 추가
	public String getSecurityPwd(String id);
	public Member getMemberInfo(String id);
}
