package com.pmc.final_project.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.PcRoomBean;

import com.pmc.final_project.dao.IPcRoom;
import com.pmc.final_project.util.fileUpload;

@Service
public class PcroomManagement {
	
	private ModelAndView mav;
	
	@Autowired
	private IPcRoom pDao;//servlet-context.xml의 pDao 객체와 연결
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	fileUpload fb;
	
	
	

	public ModelAndView JSPSignUp(PcRoomBean pr) {
		// TODO Auto-generated method stub
		
		mav = new ModelAndView();
		String view = null;
		
		if(!(pr.getP_pass().equals(pr.getP_pass2()))) {//비밀번호, 비밀번호 확인의 String 값이 서로 다를 경우 
			view = "SignUp";
			mav.addObject("ck",1);
			mav.setViewName(view);
			return mav;
		}
		
		
		
		//패스워드 spring-security로 이용하여 암호화
		BCryptPasswordEncoder pwdEncoder = 
				new BCryptPasswordEncoder();
		
		pr.setP_pass(pwdEncoder.encode(pr.getP_pass()));
		
		//DB insert 
		if(pDao.JSPSignUp(pr)) {
			//성공
			view = "Login";
			mav.addObject("check",1);
		}
		else {
			//실패
			view="SignUp";
		}
		mav.setViewName(view);
		
		
		return mav;
	}


	public ModelAndView JSPLoginCall(PcRoomBean pr) {
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
				view = "redirect:/SignUp";
			}
			else {
				view = "Login";
				mav.addObject("check",2);
			}
		}
		else {
			view = "Login";
			mav.addObject("check",2);
		}
		
		
		mav.setViewName(view);
		
		return mav;
	}
	public ModelAndView insertfileroot(MultipartHttpServletRequest multi) {
		ModelAndView mav = new ModelAndView();
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		mav.setView(view);
		String root = null;
		root = fb.upFile(multi);
		mav.addObject("src",root);
		
		return mav;
	}

	

}
