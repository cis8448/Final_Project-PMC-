package com.pmc.final_project.dao;

import java.util.List;

import com.pmc.final_project.bean.SeatBean;

public interface ISeatDao {

	public int selectCount(String id);

	public void insertSeat(SeatBean sb);

	public List<SeatBean> selectAll(String p_id);

	public void deleteSeat(SeatBean seatBean);

}
