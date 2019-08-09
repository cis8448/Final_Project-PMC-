package com.pmc.final_project.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.pmc.final_project.dao.IPcRoom;
import com.pmc.final_project.dao.IProductDao;



@Component
public class FileProcess {
	@Autowired
	private IProductDao prDao;
	
	@Autowired
	private IPcRoom pDao;
	
	@Autowired
	HttpSession session;

	public boolean upFile(MultipartHttpServletRequest multi) {
		// TODO Auto-generated method stub
		String root = "C:\\Users\\13\\Documents\\Final_Project-PMC-\\Eclipseworkspace\\Final_PMC_Project\\src\\main\\webapp\\";
		String path = root + "resources\\file\\";

		File dir = new File(path);
		if(!dir.isDirectory()) {
			dir.mkdir();
		}

		Iterator<String> files = multi.getFileNames();
		Map<String, String> fMap = new HashMap<String, String>();


		boolean f = false;

		while(files.hasNext()) {
			String fileName = files.next();
			MultipartFile mf = multi.getFile(fileName);
			//원래 파일 이름
			
			String oriName = mf.getOriginalFilename();
		
			
			String _id = (String)session.getAttribute("id");
			
			fMap.put("sysid",_id);
			fMap.put("oriFileName", oriName);
			//a.txt
			//실제 저장할 파일 이름 생성
			String sysName = System.currentTimeMillis()
					+ oriName.substring
					(oriName.lastIndexOf("."));
			//1123234354.txt
			fMap.put("sysFileName", sysName);
			

			try {
				mf.transferTo(new File(path + sysName));
				//파일 데이터 저장
				String sel = (String)multi.getParameter("sel");
				fMap.put("sel",sel);
				
				if(sel.equals("0")) {
					f = pDao.fileupdate(fMap);					
				}if(sel.equals("1")) {
					f = pDao.fileupdate1(fMap);
				}if(sel.equals("2")) {
					f = pDao.fileupdate2(fMap);
				}if(sel.equals("3")) {
					f = pDao.fileupdate3(fMap);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

		return f;
	}

	
	
	public void downFile(String path, String sysFileName, HttpServletResponse resp) throws Exception {
		//한글 깨짐 방지
		String downFile = URLEncoder.encode(sysFileName,"UTF-8");

		File file = new File(path);

		InputStream is = new FileInputStream(file);
		resp.setContentType("application/octet-stream");
		resp.setHeader("content-Disposition", "attachment; file=\""+downFile+"\"");
		//filename="파일이름.txt"
		OutputStream os = resp.getOutputStream();

		//출력은 바이트 단위로
		byte[] buffer = new byte[1024];
		int length;
		while((length=is.read(buffer))!= -1) {
			os.write(buffer,0,length);

		}

		os.flush();
		os.close();
		is.close();
	}

	public HashMap<String, String> ProductFile(MultipartHttpServletRequest multi, String _id) {
		// TODO Auto-generated method stub
		String root = "C:\\Users\\94\\Documents\\Final_Project-PMC-\\Eclipseworkspace\\Final_PMC_Project\\src\\main\\webapp\\";
		System.out.println(root);
		String path = root + "resources/file/";

		File dir = new File(path);
		if(!dir.isDirectory()) {
			dir.mkdir();
		}

		Iterator<String> files = multi.getFileNames();
		HashMap<String, String> fMap = new HashMap<String, String>();


		boolean f = false;

		while(files.hasNext()) {
			String fileName = files.next();
			MultipartFile mf = multi.getFile(fileName);
			//원래 파일 이름
			
			String oriName = mf.getOriginalFilename();
			
			
			
			fMap.put("sysid",_id);
			fMap.put("oriFileName", oriName);
			//a.txt
			//실제 저장할 파일 이름 생성
			String sysName = System.currentTimeMillis()
					+ oriName.substring
					(oriName.lastIndexOf("."));
			//1123234354.txt
			fMap.put("sysFileName", sysName);

			try {
				mf.transferTo(new File(path + sysName));
				//파일 데이터 저장
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
				
		return fMap;
	}
	public HashMap<String, String> Productup(MultipartHttpServletRequest multi, String _id) {
		// TODO Auto-generated method stub
		String root = "C:\\Users\\94\\Documents\\Final_Project-PMC-\\Eclipseworkspace\\Final_PMC_Project\\src\\main\\webapp\\";
		
		String path = root + "resources/file/";
		HashMap<String, String> fMap = new HashMap<String, String>();
		File dir = new File(path);
		if(!dir.isDirectory()) {
			dir.mkdir();
		}else {
			File[] list = dir.listFiles();
			if(list != null) {
			for(int i = 0; i < list.length; i++) {
				if(multi.getParameter("src").equals(list[i].getName())) {
					list[i].delete();
				}
			}
			}
		}
		
		Iterator<String> files = multi.getFileNames();
		
		boolean f = false;

		while(files.hasNext()) {
			String fileName = files.next();
			MultipartFile mf = multi.getFile(fileName);
			//원래 파일 이름
			
			String oriName = mf.getOriginalFilename();
			
			
			
			fMap.put("sysid",_id);
			fMap.put("oriFileName", oriName);
			//a.txt
			//실제 저장할 파일 이름 생성
			String sysName = System.currentTimeMillis()
					+ oriName.substring
					(oriName.lastIndexOf("."));
			//1123234354.txt
			fMap.put("pr_img", sysName);

			try {
				mf.transferTo(new File(path + sysName));
				//파일 데이터 저장
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
				
		return fMap;
	}
}
