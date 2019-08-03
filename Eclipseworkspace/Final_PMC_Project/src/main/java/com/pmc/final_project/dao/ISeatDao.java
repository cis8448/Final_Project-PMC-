package com.pmc.final_project.dao;

import java.util.HashMap;
import java.util.List;

import com.pmc.final_project.bean.SeatBean;

public interface ISeatDao {

	public int selectCount(String id);

	public boolean insertSeat(SeatBean sb);

	public List<SeatBean> selectAll(String p_id);

	public boolean deleteSeat(SeatBean seatBean);

	public boolean UpdateSpec(HashMap<String, String> map);

	public String selectSpec(String p_id);


}
