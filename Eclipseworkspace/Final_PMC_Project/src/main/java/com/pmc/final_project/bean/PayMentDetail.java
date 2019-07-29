package com.pmc.final_project.bean;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("PayMentDetail")
public class PayMentDetail {
	
	private String PL_M_ID;
	private String PL_P_ID;
	private String PL_PC_NAME;
	private String PL_U_START;
	private String PL_U_FINISH;
	private String PL_PL_ID;
	private String PL_PL_NAME;
	private int PL_PL_QTY;
	private int PL_PL_PRICE;
	
	public String getPL_M_ID() {
		return PL_M_ID;
	}
	public void setPL_M_ID(String pL_M_ID) {
		PL_M_ID = pL_M_ID;
	}
	public String getPL_P_ID() {
		return PL_P_ID;
	}
	public void setPL_P_ID(String pL_P_ID) {
		PL_P_ID = pL_P_ID;
	}
	public String getPL_PC_NAME() {
		return PL_PC_NAME;
	}
	public void setPL_PC_NAME(String pL_PC_NAME) {
		PL_PC_NAME = pL_PC_NAME;
	}
	public String getPL_U_START() {
		return PL_U_START;
	}
	public void setPL_U_START(String pL_U_START) {
		PL_U_START = pL_U_START;
	}
	public String getPL_U_FINISH() {
		return PL_U_FINISH;
	}
	public void setPL_U_FINISH(String pL_U_FINISH) {
		PL_U_FINISH = pL_U_FINISH;
	}
	public String getPL_PL_ID() {
		return PL_PL_ID;
	}
	public void setPL_PL_ID(String pL_PL_ID) {
		PL_PL_ID = pL_PL_ID;
	}
	public String getPL_PL_NAME() {
		return PL_PL_NAME;
	}
	public void setPL_PL_NAME(String pL_PL_NAME) {
		PL_PL_NAME = pL_PL_NAME;
	}
	public int getPL_PL_QTY() {
		return PL_PL_QTY;
	}
	public void setPL_PL_QTY(int pL_PL_QTY) {
		PL_PL_QTY = pL_PL_QTY;
	}
	public int getPL_PL_PRICE() {
		return PL_PL_PRICE;
	}
	public void setPL_PL_PRICE(int pL_PL_PRICE) {
		PL_PL_PRICE = pL_PL_PRICE;
	}
	
}
