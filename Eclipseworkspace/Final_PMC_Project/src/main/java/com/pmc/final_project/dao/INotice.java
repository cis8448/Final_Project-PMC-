package com.pmc.final_project.dao;

import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.bean.PcRoomNoticeBean;

import com.pmc.final_project.bean.Reply;

public interface INotice {

	List<PcRoomNoticeBean> getNoticeList(String cate);

	int getNoticeCount(String cate);

	List<PcRoomNoticeBean> getServiceList(String cate);

	int getServiceCount(String cate);

	boolean writeinsert(PcRoomNoticeBean pcRoomNoticeBean);

	PcRoomNoticeBean NoticeDetail(Map<String, String> map);

	boolean NoticeDelete(Map<String, String> map);
	
	boolean NoticeUpdate(PcRoomNoticeBean nbean);

	boolean swriteinsert(PcRoomNoticeBean pcRoomNoticeBean);

	PcRoomNoticeBean ServiceDetail(Map<String, String> map);

	boolean replyInsert(Reply r);

	List<Reply> getReplyList(int r_num);

	



	

	














	



}
