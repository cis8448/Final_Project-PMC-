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


import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.bean.PcRoomNoticeBean;
import com.pmc.final_project.bean.PcRoomSCBean;
import com.pmc.final_project.bean.Reply;
import com.pmc.final_project.dao.INotice;
import com.pmc.final_project.util.Paging;



@Service
public class NoticeManagement {

	private ModelAndView mav;

	@Autowired
	private INotice nDao;

	@Autowired
	HttpSession session;

	public ModelAndView getPcmasterNotice(Integer noticeNum) {
		mav = new ModelAndView();
		String view = null;
		List<PcRoomNoticeBean> nList =null;
		//noticeNum이 널이면(로그인 한후) 첫페이지를 보이도록.
		int num = (noticeNum == null) ? 1 : noticeNum;
		//이 부분 지워야함.
		
		nList = nDao.getPcmasterNotice(num);
		
		mav.addObject("nList", nList);
		mav.addObject("noticePaging", getnoticePaging(num));
		
		view = "PcmasterNotice";
		mav.setViewName(view);

		return mav;
	}


	private String getnoticePaging(int num) {
		//전체 글수
		int maxNum = nDao.getNoticeCount();
		//페이지 당 글수
		int listCnt = 10;
		//그룹당 페이지 수
		int pageCnt = 5;
		//게시판이 여러 종류가 있다면 
		String NoticeName = "PcmasterNotice";
		Paging paging = 
				new Paging(maxNum, num, listCnt, 
						pageCnt, NoticeName);

		return paging.makeHtmlpaging();
	}


	public ModelAndView NoticeWrite(PcRoomNoticeBean pcroomnoticebean) {
		mav = new ModelAndView();
		String view = null;
		
		pcroomnoticebean.setNo_p_id(session.getAttribute("id").toString());
		System.out.println(pcroomnoticebean.getNo_p_id()+"아이디");
		
//		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
//		Date time = new Date();
//		 
//	
//
//
//		pcroomnoticebean.setNo_date(format1.format(time));
//		
			if(nDao.NoticeInsert(pcroomnoticebean)) {
				System.out.println("성공");
				view = "redirect:PcmasterNotice";
			}
			else {
				System.out.println("실패");

				view = "PcNoticeWrite";
				
			}
		
			mav.setViewName(view);
			
		return mav;
	}


	public ModelAndView getContents(Integer no_num) {
		mav = new ModelAndView();
		String view = null;
		
		PcRoomNoticeBean pcroomnoticebean = nDao.getContents(no_num);
		mav.addObject("pcroomnoticebean", pcroomnoticebean);
		
		
		view = "NoticeDetail";
		mav.setViewName(view);
		
		return mav;
	}
	public ModelAndView getMaContents(Integer no_num) {
		mav = new ModelAndView();
		String view = null;
		
		PcRoomNoticeBean pcroomnoticebean = nDao.getMaContents(no_num);
		mav.addObject("pcroomnoticebean", pcroomnoticebean);
		
		view = "MaNoticeDetail";
		mav.setViewName(view);
		return mav;
	}

	public ModelAndView getSCContents(Integer se_num) {
		mav = new ModelAndView();
		String view = null;
		
		PcRoomSCBean pcroomscbean = nDao.getSCContents(se_num);
		mav.addObject("pcroomscbean", pcroomscbean);
		
		view = "CustomerScDetail";
		mav.setViewName(view);
		return mav;
	
	}


	public ModelAndView NoticeDelete(Integer no_num) 
			throws RuntimeException {
		mav = new ModelAndView();
		
		boolean n = nDao.NoticeDelete(no_num);
		if(n == false) {
			mav.addObject("check", 2);
			throw new RuntimeException();
		}
		else {
			mav.addObject("check", 1);
		}
		
		mav.setViewName("redirect:PcmasterNotice");
	
		
		return mav;
	}


	public Map<String, List<Reply>> replyInsert(Reply r) {
		Map<String, List<Reply>> jMap = null;
		r.setR_id(session.getAttribute("id").toString());
		if(nDao.replyInsert(r)) {
			List<Reply> rList = nDao.getReplyList(r.getR_se_num());
			jMap = new HashMap<String, List<Reply>>();
			jMap.put("rList", rList);
		}
		else {
			jMap = null;
		}
		return jMap;
	}


	


}


