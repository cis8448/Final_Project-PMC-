package com.pmc.final_project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.bean.PcRoomNoticeBean;
import com.pmc.final_project.dao.INotice;
import com.pmc.final_project.util.Paging;



@Service
public class NoticeManagement {

	private ModelAndView mav;
	
	@Autowired
	private INotice nDao;
	
	@Autowired
	HttpSession session;

		public ModelAndView PcNoticeWrite(PcRoomNoticeBean pcroomnotice) {
			mav = new ModelAndView();
			String view = null;
			
			pcroomnotice.setNo_p_id(session.getAttribute("id").toString());
			
			if(nDao.NoticeInsert(pcroomnotice)) {
				view = "redirect:Master";
			}
			else {
				view = "PcNoticeWrite";
			}
			
			mav.setViewName(view);
			
			return mav;
			
		}
			
		}
		

