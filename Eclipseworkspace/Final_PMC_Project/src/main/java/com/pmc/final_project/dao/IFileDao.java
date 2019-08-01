package com.pmc.final_project.dao;

import java.util.Map;

import com.pmc.final_project.bean.FileBean;

public interface IFileDao {

	boolean fileInsert(Map<String, String> fMap);

	FileBean SelectFile(String p_id);

}
