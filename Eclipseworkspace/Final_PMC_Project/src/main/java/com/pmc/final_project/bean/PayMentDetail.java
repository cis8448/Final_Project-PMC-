package com.pmc.final_project.bean;


import org.apache.ibatis.type.Alias;

@Alias("PayMentDetail")
public class PayMentDetail {
	
	
	private String m_id;
	private String p_id;
	private String pc_name;
	private String u_start;
	private String u_finish;
	private String pr_name;
	private int pl_qty;
	private int pl_price;
	private String u_m_id;
	private String pc_p_id;
	
	public String getU_m_id() {
		return u_m_id;
	}
	public void setU_m_id(String u_m_id) {
		this.u_m_id = u_m_id;
	}
	public String getPc_p_id() {
		return pc_p_id;
	}
	public void setPc_p_id(String pc_p_id) {
		this.pc_p_id = pc_p_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setU_M_id(String m_id) {
		this.m_id = m_id;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getPc_name() {
		return pc_name;
	}
	public void setPc_name(String pc_name) {
		this.pc_name = pc_name;
	}
	public String getU_start() {
		return u_start;
	}
	public void setU_start(String u_start) {
		this.u_start = u_start;
	}
	public String getU_finish() {
		return u_finish;
	}
	public void setU_finish(String u_finish) {
		this.u_finish = u_finish;
	}
	public String getPr_name() {
		return pr_name;
	}
	public void setPr_name(String pr_name) {
		this.pr_name = pr_name;
	}
	public int getPl_qty() {
		return pl_qty;
	}
	public void setPl_qty(int pl_qty) {
		this.pl_qty = pl_qty;
	}
	public int getPl_price() {
		return pl_price;
	}
	public void setPl_price(int pl_price) {
		this.pl_price = pl_price;
	}
	
	
	
	
	
}
