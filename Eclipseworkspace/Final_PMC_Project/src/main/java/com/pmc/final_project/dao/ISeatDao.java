package com.pmc.final_project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.SeatBean;

public interface ISeatDao {

	public int selectCount(String id);

	public boolean insertSeat(SeatBean sb);

	public List<SeatBean> selectAll(String p_id);

	public boolean deleteSeat(SeatBean seatBean);

	public boolean UpdateSpec(HashMap<String, String> map);

	public String selectSpec(String p_id);

	public boolean UpdateSeatReserve(HashMap<String, String> map);

	public String SelectRe(String s_id);

	public String GetPicture2(String id);

	public String seatSearch(String id);

	public String useseatSearch(String id);

	public boolean InsertsReserve(Map map);

	public int reserveConfirm(Map map);

	public boolean reserveDelete(Map map);
	
	


}
