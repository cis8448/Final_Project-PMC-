package com.pmc.final_project.bean;

import org.apache.ibatis.type.Alias;

@Alias("pcfile")
public class PcFileBean {
	private String pc_id;
	private String bf_sysName;
	public String getPc_id() {
		return pc_id;
	}
	public void setPc_id(String pc_id) {
		this.pc_id = pc_id;
	}
	public String getBf_sysName() {
		return bf_sysName;
	}
	public void setBf_sysName(String bf_sysName) {
		this.bf_sysName = bf_sysName;
	}
	
	
	
}
