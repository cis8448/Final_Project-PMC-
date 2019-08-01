package com.pmc.final_project.bean;

import org.apache.ibatis.type.Alias;

@Alias("SeatBean")
public class SeatBean {
	private String p_id;
	private String s_id;
	private String s_state;
	private String s_spec;
	private String s_noreserve;
	private String m_id;
	private String m_time;
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_state() {
		return s_state;
	}
	public void setS_state(String s_state) {
		this.s_state = s_state;
	}
	public String getS_spec() {
		return s_spec;
	}
	public void setS_spec(String s_spec) {
		this.s_spec = s_spec;
	}
	public String getS_noreserve() {
		return s_noreserve;
	}
	public void setS_noreserve(String s_noreserve) {
		this.s_noreserve = s_noreserve;
	}
	
	
}
