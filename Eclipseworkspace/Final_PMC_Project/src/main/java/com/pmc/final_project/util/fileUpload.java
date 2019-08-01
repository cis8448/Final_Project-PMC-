package com.pmc.final_project.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pmc.final_project.dao.IFileDao;
import com.pmc.final_project.service.PcroomManagement;
@Service
public class fileUpload {
	
	@Autowired
	IFileDao fDao;
	
	public String upFile(MultipartHttpServletRequest multi) {
		//파일을 저장할 절대 경로 찾기
		String root = multi.getSession().
				getServletContext().getRealPath("/");
		String p_id = multi.getParameter("p_id");
		String path = root + "resources/"+p_id;
		File Folder = new File(path);
		if(!Folder.exists()) {
			try {
				Folder.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//파일이 2개 이상일 때
		Iterator<String> files = multi.getFileNames();

		Map<String, String> fMap = new HashMap<String, String>();

		//글번호를 map에 저장
		fMap.put("p_id", p_id);

		boolean f = false;

		//파일을 여러개 처리해야 하기 때문에 반복
		while(files.hasNext()) {
			String fileName = files.next();

			MultipartFile mf = multi.getFile(fileName);
			//원래 파일 이름
			String oriName = mf.getOriginalFilename();
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
				f = fDao.fileInsert(fMap);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

		return root+fMap.get("sysFileName");
	}
}
