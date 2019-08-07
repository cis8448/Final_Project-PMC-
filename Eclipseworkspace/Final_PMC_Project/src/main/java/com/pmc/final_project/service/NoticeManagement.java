package com.pmc.final_project.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.bean.Member;
import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.bean.PcRoomNoticeBean;

import com.pmc.final_project.bean.Reply;
import com.pmc.final_project.dao.INotice;
import com.pmc.final_project.util.Paging;



@Service
public class NoticeManagement {

	private ModelAndView mav;

	@Autowired
	private INotice nDao;

	@Autowired
	private HttpSession session;

	public ModelAndView getNoticeList(Integer pageNum, String cate) {
		mav = new ModelAndView();
		String view = null;
		List<PcRoomNoticeBean> nList = null;
		String p_id = (String)session.getAttribute("id");

		int num = (pageNum == null) ? 1 : pageNum;

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", p_id);
		map.put("cate", cate);

		nList = nDao.getNoticeList(cate);

		mav.addObject("nList", nList);
		mav.addObject("NoticePaging", getNoticePaging(num, cate));
		view = "NoticeList";
		mav.setViewName(view);

		return mav;
	}

	private String getNoticePaging(int num, String cate) {

		String id = (String)session.getAttribute("id");
		//전체 회원
		int maxNum = nDao.getNoticeCount(cate);
		//페이지 당 회원 수
		int listCnt = 10;
		//그룹당 페이지 수
		int pageCnt = 3;
		//게시판이 여러 종류가 있다면 
		String NoticeName = "NoticeList";
		Paging mempaging = 
				new Paging(maxNum, num, listCnt, 
						pageCnt, NoticeName);

		return mempaging.makeHtmlpaging();
	}

	public ModelAndView getServiceList(Integer pageNum, String cate) {

		String id = (String)session.getAttribute("id");
		mav = new ModelAndView();
		String view = null;
		List<PcRoomNoticeBean> nList = null;
		if(cate.equals("3")) {
			cate = "0";
		}else {
			cate = "1";
		}
		int num = (pageNum == null) ? 1 : pageNum;

		nList = nDao.getServiceList(cate);

		mav.addObject("nList", nList);
		mav.addObject("NoticePaging", getServicePaging(num, cate));
		view = "ServiceList";
		mav.setViewName(view);

		return mav;
	}
	private String getServicePaging(int num, String cate) {

		String id = (String)session.getAttribute("id");
		//전체 회원
		int maxNum = nDao.getServiceCount(cate);
		//페이지 당 회원 수
		int listCnt = 10;
		//그룹당 페이지 수
		int pageCnt = 3;
		//게시판이 여러 종류가 있다면 
		String ServiceName = "NoticeList";
		Paging mempaging = 
				new Paging(maxNum, num, listCnt, 
						pageCnt, ServiceName);

		return mempaging.makeHtmlpaging();
	}

	public ModelAndView writeinsert(PcRoomNoticeBean pcRoomNoticeBean) {
		mav = new ModelAndView();

		pcRoomNoticeBean.setNo_p_id((String)session.getAttribute("id"));
		
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
		Calendar c1 = Calendar.getInstance();
		String strToday = date.format(c1.getTime());

		pcRoomNoticeBean.setNo_date(strToday);

		String view = null;
		if(pcRoomNoticeBean.getNo_cate()==4) {
			pcRoomNoticeBean.setNo_cate(4);
			if(nDao.swriteinsert(pcRoomNoticeBean)) {
				view= "redirect:/ServiceList?cate="+pcRoomNoticeBean.getNo_cate();
			}
		}else {
			pcRoomNoticeBean.setNo_cate(0);
			if(nDao.writeinsert(pcRoomNoticeBean)) {
				mav.addObject("check","1"); 
				view = "redirect:/NoticeList?cate="+pcRoomNoticeBean.getNo_cate();
			}
		}

		mav.setViewName(view);


		return mav;


	}

	public ModelAndView NoticeDetail(PcRoomNoticeBean pr) {
		mav = new ModelAndView();

		String view = null;

		String id = (String)session.getAttribute("id");

		Map<String,String> map = new HashMap<String, String>();

		map.put("id", id);
		map.put("no_num", pr.getNo_num()+"");
		PcRoomNoticeBean pcroomnoticebean = new PcRoomNoticeBean();

		
		if(pr.getNo_cate()<3) {
		pcroomnoticebean = nDao.NoticeDetail(map);
		
		}else {
			pcroomnoticebean = nDao.ServiceDetail(map);
			
		}
		mav.addObject("pcroomnoticebean", pcroomnoticebean);


		view = "NoticeDetail";
		mav.setViewName(view);

		return mav;
	}

	public ModelAndView NoticeDelete(String no_num) {
		mav = new ModelAndView();
		String view = null;		

		String id = (String)session.getAttribute("id");

		Map<String, String> map = new HashMap<String, String>();

		map.put("id", id);
		map.put("no_num", no_num);

		if(nDao.NoticeDelete(map)) {

			view = "redirect:/NoticeList?cate=0";
		}


		mav.setViewName(view);

		return mav;
	}
	
	public ModelAndView NoticeUpdate(PcRoomNoticeBean nbean) {
		mav = new ModelAndView();
		String view = null;		

		String id = (String)session.getAttribute("id");

		if(nDao.NoticeUpdate(nbean)) {
			view = "redirect:/NoticeDetail?no_num="+nbean.getNo_num();
		}
		mav.setViewName(view);

		return mav;
	}


	public Map<String, List<Reply>> replyInsert(Reply r) {
		
		Map<String, List<Reply>> jMap = null;
		r.setR_id(session.getAttribute("id").toString());
		if(nDao.replyInsert(r)) {
			List<Reply> rList = nDao.getReplyList(r.getR_num());
			jMap = new HashMap<String, List<Reply>>();
			jMap.put("BList", rList);
		}
		else {
			jMap = null;
		}
		return jMap;
	}


	


}


