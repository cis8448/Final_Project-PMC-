package com.pmc.final_project.bean;

import org.apache.ibatis.type.Alias;

@Alias("pcroomscbean")
public class PcRoomSCBean {

	private String se_m_id; //회원아이디
	private String se_p_id; //PC방아이디
	private int se_num; //고객센터 게시글번호
	private String se_title; //고객센터 게시글제목
	private String se_content; //고객센터 게시글내용
	private int se_cate; //고객센터 카테고리
	public String getSe_m_id() {
		return se_m_id;
	}
	public void setSe_m_id(String se_m_id) {
		this.se_m_id = se_m_id;
	}
	public String getSe_p_id() {
		return se_p_id;
	}
	public void setSe_p_id(String se_p_id) {
		this.se_p_id = se_p_id;
	}
	public int getSe_num() {
		return se_num;
	}
	public void setSe_num(int se_num) {
		this.se_num = se_num;
	}
	public String getSe_title() {
		return se_title;
	}
	public void setSe_title(String se_title) {
		this.se_title = se_title;
	}
	public String getSe_content() {
		return se_content;
	}
	public void setSe_content(String se_content) {
		this.se_content = se_content;
	}
	public int getSe_cate() {
		return se_cate;
	}
	public void setSe_cate(int se_cate) {
		this.se_cate = se_cate;
	}

}
