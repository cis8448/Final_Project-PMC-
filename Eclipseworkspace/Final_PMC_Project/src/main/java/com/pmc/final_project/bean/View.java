package com.pmc.final_project.bean;

import org.apache.ibatis.type.Alias;

@Alias("view")
public class View {

	private String m_id;
	private String p_id;
	private String p_name;
	private String p_addr;
	private String sp_time;
	private String sp_bookmark;
	private String pc_name;
	private String u_start;
	private String u_finish;
	private String pl_id;
	private String pl_name;
	private String pl_qty;
	private String pl_price;
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_addr() {
		return p_addr;
	}
	public void setP_addr(String p_addr) {
		this.p_addr = p_addr;
	}
	public String getSp_time() {
		return sp_time;
	}
	public void setSp_time(String sp_time) {
		this.sp_time = sp_time;
	}
	public String getSp_bookmark() {
		return sp_bookmark;
	}
	public void setSp_bookmark(String sp_bookmark) {
		this.sp_bookmark = sp_bookmark;
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
	public String getPl_id() {
		return pl_id;
	}
	public void setPl_id(String pl_id) {
		this.pl_id = pl_id;
	}
	public String getPl_name() {
		return pl_name;
	}
	public void setPl_name(String pl_name) {
		this.pl_name = pl_name;
	}
	public String getPl_qty() {
		return pl_qty;
	}
	public void setPl_qty(String pl_qty) {
		this.pl_qty = pl_qty;
	}
	public String getPl_price() {
		return pl_price;
	}
	public void setPl_price(String pl_price) {
		this.pl_price = pl_price;
	}
	
	
}
