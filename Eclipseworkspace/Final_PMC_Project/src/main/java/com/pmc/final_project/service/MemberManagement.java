package com.pmc.final_project.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project_bean.Member;
import com.pmc.final_project_dao.IMemberDao;

@Service
public class MemberManagement {
	private ModelAndView mav;
	
	@Autowired
	private IMemberDao mDao;
	//servlet-context.xml의 mDao 객체와 연결
	
	@Autowired
	private HttpSession session;

	public ModelAndView memberInsert(Member mb) {
		mav = new ModelAndView();
		String view = null;
		
		//패스워드 암호화 처리
		BCryptPasswordEncoder pwdEncoder =
				new BCryptPasswordEncoder();
		
		mb.setM_pass(pwdEncoder.encode(mb.getM_pass()));
		
		//DB insert
		if(mDao.memberInsert(mb)) {
			//성공
			view = "home";//로그인 페이지로 이동
			mav.addObject("check", 1);
		}
		else {
			//실패
			view = "joinFrm";
		}
		mav.setViewName(view);
		
		return mav;
	}

	public ModelAndView memberAccess(Member mb) {
		mav = new ModelAndView();
		String view = null;
		
		BCryptPasswordEncoder pwdEncoder =
				new BCryptPasswordEncoder();
		
		//DB에서 암호화된 패스워드 얻어오기
		String endPass = mDao.getSecurityPwd(mb.getM_id());
		
		if(endPass != null) {
			if(pwdEncoder.matches(mb.getM_pass(), endPass)) {
				session.setAttribute("id", mb.getM_id());
				//메인 화면으로 전환..
				// -> 게시판 목록(이후 처리)
				// 로그인한 회원의 일부정보
				mb = mDao.getMemberInfo(mb.getM_id());
				mav.addObject("mb", mb);
				view = "redirect:/boardList";
			}
			else {
				view = "home";
				mav.addObject("check", 2);
			}
		}
		else {
			view = "home";
			mav.addObject("check", 2);
		}
		mav.setViewName(view);
		return mav;
	}
	
	
}





