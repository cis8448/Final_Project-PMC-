package com.pmc.final_project.bean;

import org.apache.ibatis.type.Alias;

@Alias("ProductBean")
public class ProductBean {
	
	private String pc_id;
	private String pr_id;
	private String pr_name;
	private String pr_price;
	private String pr_img;
	private int pr_qty;
	private String pc_name;
	private String p_id;
	
	
	
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
	public String getPc_id() {
		return pc_id;
	}
	public void setPc_id(String pc_id) {
		this.pc_id = pc_id;
	}
	public String getPr_id() {
		return pr_id;
	}
	public void setPr_id(String pr_id) {
		this.pr_id = pr_id;
	}
	public String getPr_name() {
		return pr_name;
	}
	public void setPr_name(String pr_name) {
		this.pr_name = pr_name;
	}
	public String getPr_price() {
		return pr_price;
	}
	public void setPr_price(String pr_price) {
		this.pr_price = pr_price;
	}
	public String getPr_img() {
		return pr_img;
	}
	public void setPr_img(String pr_img) {
		this.pr_img = pr_img;
	}
	public int getPr_qty() {
		return pr_qty;
	}
	public void setPr_qty(int pr_qty) {
		this.pr_qty = pr_qty;
	}
	
	
	
	
	
	
	
	
}
