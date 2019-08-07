package com.pmc.final_project.bean;

import org.apache.ibatis.type.Alias;

@Alias("Member")
public class Member {
	
	private int m_kakaoid;
	private String m_id;
	private String m_pass;
	private String m_name;
	private String m_nickname;
	private String m_email;
	private String m_phone;
	private String m_birthday;
	private String m_profile;
	private String m_point;
	private String m_time;

	public int getM_kakaoid() {
		return m_kakaoid;
	}
	public void setM_kakaoid(int m_kakaoid) {
		this.m_kakaoid = m_kakaoid;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pass() {
		return m_pass;
	}
	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_birthday() {
		return m_birthday;
	}
	public void setM_birthday(String m_birthday) {
		this.m_birthday = m_birthday;
	}
	public String getM_profile() {
		return m_profile;
	}
	public void setM_profile(String m_profile) {
		this.m_profile = m_profile;
	}
	public String getM_point() {
		return m_point;
	}
	public void setM_point(String m_point) {
		this.m_point = m_point;
	}
	public String getM_time() {
		return m_time;
	}
	public void setM_time(String m_retime) {
		this.m_time = m_retime;
	}
	
	
}
