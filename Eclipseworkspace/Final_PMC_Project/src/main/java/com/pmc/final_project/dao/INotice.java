package com.pmc.final_project.dao;

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

}
