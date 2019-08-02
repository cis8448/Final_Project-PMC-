package com.pmc.final_project.bean;

import org.apache.ibatis.type.Alias;

@Alias("fileBean")
public class FileBean {
	private String p_id;
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	
	

}
