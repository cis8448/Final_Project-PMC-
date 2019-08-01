package com.pmc.final_project.dao;

import java.util.Map;

import com.pmc.final_project.bean.FileBeans;

public interface IFileDao {

	public boolean fileInsert(Map<String, String> fMap);
	
	public FileBeans SelectFile(String p_id);

}
