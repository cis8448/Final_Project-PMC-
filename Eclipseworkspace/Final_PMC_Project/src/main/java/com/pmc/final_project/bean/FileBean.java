package com.pmc.final_project.bean;

import org.apache.ibatis.type.Alias;

@Alias("FileBean")
public class FileBean {
	private String c_p_id;
	private String c_content;
	public String getC_p_id() {
		return c_p_id;
	}
	public void setC_p_id(String c_p_id) {
		this.c_p_id = c_p_id;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	
	
	
	
	
	

}
