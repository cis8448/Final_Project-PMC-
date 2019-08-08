package com.pmc.final_project.bean;

import java.sql.Timestamp;


import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("reply")
public class Reply {

	private int r_num;//댓글번호
	private int r_se_num;//글번호
	private String r_contents;//댓글내용
	@JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Timestamp r_date;
	private String r_id;
	
	
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public int getR_se_num() {
		return r_se_num;
	}
	public void setR_se_num(int r_se_num) {
		this.r_se_num = r_se_num;
	}
	public String getR_contents() {
		return r_contents;
	}
	public void setR_contents(String r_contents) {
		this.r_contents = r_contents;
	}
	public Timestamp getR_date() {
		return r_date;
	}
	public void setR_date(Timestamp r_date) {
		this.r_date = r_date;
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

}
