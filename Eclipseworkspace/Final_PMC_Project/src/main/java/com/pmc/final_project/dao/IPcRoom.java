package com.pmc.final_project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pmc.final_project.bean.Member;
import com.pmc.final_project.bean.MyPcBean;
import com.pmc.final_project.bean.PcRoomBean;

public interface IPcRoom {

	public boolean JSPSignUp(PcRoomBean pcroom);

	public String getSecurityPwd(String id);

	public PcRoomBean getMemberInfo(String id);

	public int PCIdCheck(String userid);

	public String idsearch(PcRoomBean pr);

	public boolean pwsearch(Map<String,String> map);

	public String emailsearch(PcRoomBean pr);

	public int idselinfo(PcRoomBean pr);

	public int pwselinfo(PcRoomBean pr);

	public int accept(String userid);

	public boolean fileupdate(Map<String, String> fMap);

	public void changeName(PcRoomBean pr);

	public void changePhone(PcRoomBean pr);

	public void changepw2(Map<String, String> map);

	public List<PcRoomBean> selectAll(int num);

	public int getSBPCCount();

	public void approvalDelete(String id);

	public PcRoomBean approvalSelect(String id);

	public boolean approvalInsert(PcRoomBean pr);

	public List<PcRoomBean> getFileList(String id);

	public List<PcRoomBean> selectAll2(int num);

	public void approvalx(Map<Object, Object> map);

	public String HoliSel(String p_id);


	public boolean fileupdate1(Map<String, String> fMap);

	public boolean fileupdate2(Map<String, String> fMap);

	public boolean fileupdate3(Map<String, String> fMap);

	public void negative(String id);

	public List<String> GetPicture();

	public String Memberidoverlap(String id);

	public boolean InsertMember(Member member);

	public boolean InsertKakaoMember(Member member);

	public Member EazyLogin(String kakaoId);

	public Member MemberLogin(HashMap<String, String> map);

	public String MemberGetId(String hp);

	public boolean UpdatePass(HashMap<String, String> map);

	public String SaerchEmail(String hp);

	public List<MyPcBean> SelectMyPc(String name);

	public void bookmarkUp(MyPcBean myPcBean);

	public boolean pcjoinDelete(HashMap<String, String> maps);
	
	public List<PcRoomBean> info();

	public List<String> getsido();

	public List<String> DongListSet(String sido);

	public List<MyPcBean> dongPcList(String dong);

	public boolean PCSignUp(Map map);

	public MyPcBean Reselect(Map map);














}

