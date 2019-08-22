package com.pmc.final_project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.bean.PcRoomNoticeBean;

import com.pmc.final_project.bean.Reply;

public interface INotice {

	List<PcRoomNoticeBean> OM_Notice(Map<String, String> map);

	List<PcRoomNoticeBean> OM_Service(Map<String, String> map);

	PcRoomNoticeBean OM_NoticeInfo(String no_num);

	PcRoomNoticeBean OM_ServiceInfo(String no_num);

	List<PcRoomNoticeBean> OMNoticeSearch(String res2);


	void OM_NInsert(PcRoomNoticeBean pb);

	List<PcRoomNoticeBean> getNoticeList(String cate);

	PcRoomNoticeBean getNoticeDetail(String b_num);

	boolean UpdateNotice(PcRoomNoticeBean noBean);

	boolean DeleteNotice(String b_num);

	List<PcRoomNoticeBean> getServiceList(String cate);

	PcRoomNoticeBean getServiceDetail(String b_num);

	boolean UpdateService(PcRoomNoticeBean noBean);

	boolean DeleteService(String b_num);

	Object SelectP_id(String b_num);

	List<PcRoomNoticeBean> getPcNoticeList(HashMap<String, String> map);

	void InserNotice(PcRoomNoticeBean noticeBean);


}
