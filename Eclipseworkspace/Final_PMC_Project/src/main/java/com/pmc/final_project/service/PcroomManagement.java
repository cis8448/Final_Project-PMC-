package com.pmc.final_project.service;


import java.util.HashMap;

import java.util.Map;
import java.util.Random;
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
import com.pmc.final_project.util.FileProcess;
import com.pmc.final_project.util.FindUtil;
import com.pmc.final_project.util.MailUtil;
import com.pmc.final_project.util.fileUpload;

@Service
public class PcroomManagement {

	private ModelAndView mav;

	@Autowired
	private IPcRoom pDao;

	@Autowired
	private HttpSession session;

	@Autowired
	fileUpload fb;
	
	@Autowired
	FileProcess fileProc;




	public ModelAndView JSPSignUp(PcRoomBean pr) {
		// TODO Auto-generated method stub

		mav = new ModelAndView();
		String view = null;
		
		if(!(pr.getP_pass().equals(pr.getP_pass2()))) {//비밀번호, 비밀번호 확인의 String 값이 서로 다를 경우 
			System.out.println("오긴왔어1");
			mav.addObject("ck",1);
			view = "redirect:/SignUp";
			mav.setViewName(view);
			return mav;
		}
		
		
		

		//패스워드 spring-security로 이용하여 암호화
		BCryptPasswordEncoder pwdEncoder = 
				new BCryptPasswordEncoder();

		pr.setP_pass((pwdEncoder.encode(pr.getP_pass())));
		System.out.println("오긴왔어2");
		boolean f = false;
		//DB insert 
		if(pDao.JSPSignUp(pr)) {
			//성공
			view = "Login";
			mav.addObject("check",1);
			System.out.println("오긴왔어3");
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
		System.out.println("첫번쨰11 ");
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		System.out.println("첫번쨰222 ");
		//DB에서 암호화된 패스워드 얻어오기
		String endPwd = pDao.getSecurityPwd(pr.getP_id());
		System.out.println("첫번쨰22 ");
		if(endPwd != null) {
			if(pwdEncoder.matches(pr.getP_pass(), endPwd)) {//내부적으로 db에 암호화된 비밀번호와 비교하여 일치하면T 아니면 f로 리턴
				System.out.println("두번쨰 33");
				session.setAttribute("id", pr.getP_id());
				
				//메인 화면으로 전환..
				//=>게시판 목록
				// 로그인한 회원의 일부정보, 게시글 목록
				System.out.println("비밀번호변경");
				pr = pDao.getMemberInfo(pr.getP_id());
				mav.addObject("pr",pr);
				view = "redirect:/SeatState";
				System.out.println("로그인성공");
			}
			else {
				System.out.println("로그인실패1");
				view = "redirect:/LoginFail";
				//mav.addObject("check",2);
			}
		}
		else {
			System.out.println("로그인실패2");
			view = "redirect:/LoginFail";
			//mav.addObject("check",2);
		}


		mav.setViewName(view);

		return mav;
	}


	public ModelAndView idsearch(PcRoomBean pr) {
		// TODO Auto-generated method stub

		mav = new ModelAndView();
		String view = null;


		int count = 0;
		count = pDao.idselinfo(pr);
		if(count>0) {
			String id = pDao.idsearch(pr);
			mav.addObject("p_id",2);
			mav.addObject("p_id2",id);
			System.out.println("들어왔어");
		}else {
			mav.addObject("p_id",1);
			System.out.println("틀렸어");
		}

		view="redirect:/id";
		mav.setViewName(view);

		return mav;
	}


	public ModelAndView pwsearch(PcRoomBean pr) {
		// TODO Auto-generated method stub

		mav = new ModelAndView();
		String view = null;
		Map<String,String> map = new HashMap<String, String>();

		int count = 0;
		count = pDao.pwselinfo(pr);
		if(count>0){
			String email=pDao.emailsearch(pr);
			try {
				findPwd(email);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String keyCode = (String)session.getAttribute("keyCode");
			map.put("cid",pr.getP_id());


			BCryptPasswordEncoder pwdEncoder = 
					new BCryptPasswordEncoder();
			keyCode = pwdEncoder.encode(keyCode);
			map.put("KeyCode",keyCode);
			if(pDao.pwsearch(map)) {
				//성공
				view = "redirect:/pw";
				mav.addObject("check",1);
				System.out.println("비밀번호변경1");
				session.removeAttribute("keyCode");
			}
			else {
				//실패
				System.out.println("비밀번호변경2");
				view="redirect:/pw";
				mav.addObject("check",2);
			}
		}else {
			System.out.println("비밀번호변경3");
			view="redirect:/pw";
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

	public void findPwd(String id) throws Exception {

		String keyCode = FindUtil.createKey();
		session.setAttribute("keyCode", keyCode);

		String subject = "임시 비밀번호 발송 안내";

		String msg = "";
		msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
		msg += "<h3 style='color: blue;'>임시 비밀번호 입니다.</h3>";
		msg += "<div style='font-size: 130%'>";
		msg += "비밀번호가 임시 비밀번호로 변경 되었습니다! 로그인 후 비밀번호 변경 부탁드립니다! <strong>";
		msg += keyCode + "</strong> 를 입력해주세요.</div><br/>";



		MailUtil.sendMail(id, subject, msg);

	}


	public ModelAndView fileupload(MultipartHttpServletRequest multi) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String view = null;
		
		String check = multi.getParameter("fileCheck");
		String _id = multi.getParameter("_id");
		System.out.println(_id);
		
		boolean f = false;
		
		if(check.equals("1")) {
			System.out.println("들어옴");
			f= fileProc.upFile(multi,_id);
		}
		if(f) {
			view = "SignUp";
		}
		
		mav.setViewName(view);
		
		return mav;
	}	
	

}







