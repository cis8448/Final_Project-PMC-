package com.pmc.final_project.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pmc.final_project.bean.PcRoomBean;

import com.pmc.final_project.dao.IPcRoomDao;

@Service
public class PcroomManagement {
	
	private ModelAndView mav;
	
	@Autowired
	private IPcRoomDao pDao;//servlet-context.xml의 pDao 객체와 연결
	
	@Autowired
	private HttpSession session;
	

	public ModelAndView pcroomInsert(PcRoomBean pr) {
		// TODO Auto-generated method stub
		
		mav = new ModelAndView();
		String view = null;
		
		if(!(pr.getP_pass().equals(pr.getP_pass2()))) {//비밀번호, 비밀번호 확인의 String 값이 서로 다를 경우 
			view = "joinfrm";
			mav.addObject("ck",1);
			mav.setViewName(view);
			return mav;
		}
		
		
		
		//패스워드 spring-security로 이용하여 암호화
		BCryptPasswordEncoder pwdEncoder = 
				new BCryptPasswordEncoder();
		
		pr.setP_pass(pwdEncoder.encode(pr.getP_pass()));
		
		//DB insert 
		if(pDao.pcroomInsert(pr)) {
			//성공
			view = "home";//로그인 페이지로 이동
			mav.addObject("check",1);
		}
		else {
			//실패
			view="joinfrm";
		}
		mav.setViewName(view);
		
		
		return mav;
	}


	public ModelAndView memberAccess(PcRoomBean pr) {
		// TODO Auto-generated method stub
		
		mav = new ModelAndView();
		String view = null;

		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

		//DB에서 암호화된 패스워드 얻어오기
		String endPwd = pDao.getSecurityPwd(pr.getP_id());

		if(endPwd != null) {
			if(pwdEncoder.matches(pr.getP_pass(), endPwd)) {//내부적으로 db에 암호화된 비밀번호와 비교하여 일치하면T 아니면 f로 리턴
				session.setAttribute("id", pr.getP_id());
				//메인 화면으로 전환..
				//=>게시판 목록
				// 로그인한 회원의 일부정보, 게시글 목록
				pr = pDao.getMemberInfo(pr.getP_id());
				mav.addObject("mb",pr);
				view = "redirect:/joinfrm";
			}
			else {
				view = "home";
				mav.addObject("check",2);
			}
		}
		else {
			view = "home";
			mav.addObject("check",2);
		}
		
		
		mav.setViewName(view);
		
		return mav;
	}

}
