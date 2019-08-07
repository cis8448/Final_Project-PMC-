package com.pmc.final_project.dao;

import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.bean.PcRoomNoticeBean;
import com.pmc.final_project.bean.PcRoomSCBean;
import com.pmc.final_project.bean.Reply;

public interface INotice {


	int getNoticeCount();

	List<PcRoomNoticeBean> getPcmasterNotice(int num);

	boolean NoticeInsert(PcRoomNoticeBean pcroomnoticebean);

	PcRoomNoticeBean getContents(Integer no_num);
	
	PcRoomNoticeBean getMaContents(Integer no_num);
	
	PcRoomSCBean getSCContents(Integer se_num);

	boolean NoticeDelete(Integer no_num);

	boolean replyInsert(Reply r);

	List<Reply> getReplyList(int r_se_num);

	List<PcRoomNoticeBean> OM_Notice(Map<String, String> map);

	List<PcRoomNoticeBean> OM_Service(Map<String, String> map);

	PcRoomNoticeBean OM_NoticeInfo(String no_num);

	PcRoomNoticeBean OM_ServiceInfo(String no_num);

	List<PcRoomNoticeBean> OMNoticeSearch(String res2);











	



}
