package com.pmc.final_project.bean;

import org.apache.ibatis.type.Alias;

@Alias("catelist")
public class ProductCate {
	
	private String pc_id;
	private String pc_name;
	private String p_id;
	
	public String getPc_id() {
		return pc_id;
	}
	public void setPc_id(String pc_id) {
		this.pc_id = pc_id;
	}
	public String getPc_name() {
		return pc_name;
	}
	public void setPc_name(String pc_name) {
		this.pc_name = pc_name;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	
	
}
