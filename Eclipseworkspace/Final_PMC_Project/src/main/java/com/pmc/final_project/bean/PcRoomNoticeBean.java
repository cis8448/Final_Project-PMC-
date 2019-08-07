package com.pmc.final_project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("pcroomnoticebean")
public class PcRoomNoticeBean {

	private String no_p_id; // PC아이디
	private int no_num; //공지사항 게시글번호
	private String no_title; //공지사항 게시글제목
	private String no_content; //공지사항 게시글내용
	private String no_date; //공지사항 작성시간
	private int no_cate; //공지사항 카테고리
	private String no_m_id;
	
	
	public String getNo_m_id() {
		return no_m_id;
	}
	public void setNo_m_id(String no_m_id) {
		this.no_m_id = no_m_id;
	}
	public String getNo_p_id() {
		return no_p_id;
	}
	public void setNo_p_id(String no_p_id) {
		this.no_p_id = no_p_id;
	}
	public int getNo_num() {
		return no_num;
	}
	public void setNo_num(int no_num) {
		this.no_num = no_num;
	}
	public String getNo_title() {
		return no_title;
	}
	public void setNo_title(String no_title) {
		this.no_title = no_title;
	}
	public String getNo_content() {
		return no_content;
	}
	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}
	public String getNo_date() {
		return no_date;
	}
	public void setNo_date(String no_date) {
		this.no_date = no_date;
	}
	public int getNo_cate() {
		return no_cate;
	}
	public void setNo_cate(int no_cate) {
		this.no_cate = no_cate;
	}
	
}