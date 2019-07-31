package com.pmc.final_project;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.gson.Gson;
import com.pmc.final_project.dao.IPcRoom;
import com.pmc.final_project.service.PcroomManagement;

@Controller
public class RestController {

	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	@Autowired
	private IPcRoom pDao;
<<<<<<< HEAD

=======
	@Autowired
	private PcroomManagement pm; 
	
	
>>>>>>> 5e48650e69009fe9921478f0aaf9c5972bac6a32
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

<<<<<<< HEAD
		mav.setViewName("SignUp");

		return json;
	}


=======
        mav.setViewName("SignUp");
      
        return json;
    }
	@RequestMapping(value = "/imgsave", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ModelAndView insertSeatImg(MultipartHttpServletRequest multi) {
		ModelAndView mav = new ModelAndView();
		//MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) multi;
			mav = pm.insertfileroot(multi);
			
			
		    return mav;
		   }
	
>>>>>>> 5e48650e69009fe9921478f0aaf9c5972bac6a32
}
