package com.pmc.final_project.bean;

import org.apache.ibatis.type.Alias;

@Alias("FileBean")
public class FileBean {
	private String p_id;
	private String oriFileName;
	private String sysFileName;
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getOriFileName() {
		return oriFileName;
	}
	public void setOriFileName(String oriFileName) {
		this.oriFileName = oriFileName;
	}
	public String getSysFileName() {
		return sysFileName;
	}
	public void setSysFileName(String sysFileName) {
		this.sysFileName = sysFileName;
	}
	

}