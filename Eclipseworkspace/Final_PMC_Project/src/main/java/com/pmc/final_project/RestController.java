package com.pmc.final_project;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pmc.final_project.dao.IPcRoom;

@Controller
public class RestController {

	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	@Autowired
	private IPcRoom pDao;
	
	@RequestMapping(value="/PCIdCheck", method = RequestMethod.POST)  
    public @ResponseBody String idcheck(@RequestBody String userid) {
		ModelAndView mav = new ModelAndView();
		logger.info("asdasasd execute ");
		
        int count = 0;
        Map<Object, Object> map = new HashMap<Object, Object>();
 
        count = pDao.PCIdCheck(userid);
        map.put("cnt", count);
        
        String json= null;
		json = new Gson().toJson(map);

        mav.setViewName("SignUp");
      
        return json;
    }
	
}
