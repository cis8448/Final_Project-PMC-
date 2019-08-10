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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.gson.Gson;
import com.pmc.final_project.bean.Member;
import com.pmc.final_project.bean.MyPcBean;
import com.pmc.final_project.bean.PcRoomBean;
import com.pmc.final_project.dao.IMemberDao;
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
	private IMemberDao mDao;

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
		if(!(pr.getP_pass().equals(pr.getP_pass2()))) {
			//비밀번호, 비밀번호 확인의 String 값이 서로 다를 경우 
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


		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

		//DB에서 암호화된 패스워드 얻어오기
		String endPwd = pDao.getSecurityPwd(pr.getP_id());


		if(endPwd != null) {
			if(pwdEncoder.matches(pr.getP_pass(), endPwd)) {
				//내부적으로 db에 암호화된 비밀번호와 비교하여 일치하면T 아니면 f로 리턴
				System.out.println("들어오니?");
				String holiday= pDao.HoliSel(pr.getP_id());
				if(holiday.equals("3")) {
					view = "redirect:/LoginFail";
					mav.addObject("check",1);
					mav.setViewName(view);
					return mav;
				}
				session.setAttribute("id", pr.getP_id());
				pr = pDao.getMemberInfo(pr.getP_id());
				mav.addObject("pr",pr);
				if(pr.getP_id().equals("master")) {
					view = "redirect:/OM_Main";
				}else {
					view = "redirect:/SeatState";
				}
			}
			else {
				view = "redirect:/LoginFail";
				mav.addObject("check",2);
			}
		}
		else {

			view = "redirect:/LoginFail";
			mav.addObject("check",2);
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
		
	
		System.out.println("sel="+multi.getParameter("sel"));
		boolean f = false;

		if(check.equals("1")) {
			
			f= fileProc.upFile(multi);
		}
		if(f) {
			view = "SignUp";
		}

		mav.setViewName(view);

		return mav;
	}


	public ModelAndView PCInfoUpdate(PcRoomBean pr) {
		// TODO Auto-generated method stub

		mav = new ModelAndView();
		String view = null;

		System.out.println("멤버인포"+session.getAttribute("id").toString());
		pDao.getMemberInfo(session.getAttribute("id").toString());

		view = "PCInfoUpdate";

		mav.setViewName(view);

		return mav;
	}


	public ModelAndView InfoUpdate(PcRoomBean pr) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String view = null;
		Map<String,String> map = new HashMap<String, String>();
		int count=0 ;


		if(!(pr.getP_name().equals(""))) {
			pDao.changeName(pr);
			count = 1;
		}

		if(!(pr.getP_phone().equals(""))) {
			pDao.changePhone(pr);
			count = 1;
		}

		mav.addObject("iu",count);

		view = "redirect:/PCInfoUpdate";

		mav.setViewName(view);
		return mav;
	}


	public ModelAndView changepw2(PcRoomBean pr) {
		// TODO Auto-generated method stub

		mav = new ModelAndView();
		String view = null;
		String pass=null;
		System.out.println("c2"+session.getAttribute("id"));
		String id =(String)session.getAttribute("id");
		System.out.println(id);
		System.out.println(pr.getP_pass());
		Map<String,String> map = new HashMap<String, String>();
		if((pr.getP_pass().equals(pr.getP_pass2()))) {
			BCryptPasswordEncoder pwdEncoder = 
					new BCryptPasswordEncoder();
			pass = pwdEncoder.encode(pr.getP_pass());
			System.out.println(pr.getP_id()+"비번ㅂㄴ경아디");
			map.put("id",id);
			map.put("pw",pass);
			pDao.changepw2(map);
			mav.addObject("cpw",1);
			view ="redirect:/changepw";
		}else {
			mav.addObject("cpw",2);
			view = "redirect:/changepw";
		}

		mav.setViewName(view);

		return mav;
	}


	public ModelAndView changepw(PcRoomBean pr) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String view = null;
		view = "changepw";

		mav.setViewName(view);
		return mav;
	}


	public ModelAndView PCPictureUpdate(PcRoomBean pr) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();

		String view = "PCPictureUpdate";
		mav.setViewName(view);
		return mav;
	}


	public String GetPicture() {
		Random ran = new Random();
		List<String> pList = pDao.GetPicture();
		for(int i =0; pList.size()>3; i++) {
			pList.remove(ran.nextInt(pList.size()-1));
		}
		Map<String,String> pMap = new HashMap<String, String>();
		pMap.put("Picture1", pList.get(0));
		pMap.put("Picture2", pList.get(1));
		pMap.put("Picture3", pList.get(2));
		String json = new Gson().toJson(pMap);
		return json;
	}


	public String Memberidoverlap(String id) {
		String json = pDao.Memberidoverlap(id);
		return json;
	}


	public String InsertMember(Member member) {
		String json = null;
		if(member.getM_kakaoid() == 0) {
			if(pDao.InsertMember(member)) {
				json = "1";
			}else{
				json = "0";
			}
		}else {
			if(pDao.InsertKakaoMember(member)) {
				json = "1";
			}else{
				json = "0";
			}
		}
		return json;
	}


	public String EazyLogin(String kakaoId) {
		Member mlist = pDao.EazyLogin(kakaoId);
		String json = new Gson().toJson(mlist);
		return json;
	}


	public String MemberLogin(String id, String pass) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pass", pass);
		Member mlist = pDao.MemberLogin(map);
		String json = new Gson().toJson(mlist);
		return json;
	}


	public String MemberGetId(String hp) {
		String json = pDao.MemberGetId(hp);
		return json;
	}


	public String UpdatePass(String id, String pass) {
		HashMap<String, String> map = new HashMap<String, String>();
		String json = null;
		map.put("id", id);
		map.put("pass", pass);
		if(pDao.UpdatePass(map)) {
			json = "1";
		}else {
			json = "0";
		}
		return json;
	}


<<<<<<< HEAD
	public String send(String hp) {
		String json = null;
		String email = pDao.SaerchEmail(hp);
		if( email!= null) {
			json ="1";
		}else{
			json ="0";
		}
=======
	public String MyPcGetName(String name) {
		List<MyPcBean> pList = pDao.SelectMyPc(name);
		String json = new Gson().toJson(pList);
		
>>>>>>> 3b7e28a6865137b37981d5d99fec8f0d58bd4030
		return json;
	}




}





















