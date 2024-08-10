package SpringBootApplication.Controller;


import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SpringBootApplication.dao.*;
import SpringBootApplication.entities.*;


@Controller
public class AdminController {
	@Autowired
	AdminDao dao;
	
	
	@RequestMapping("/addadmin")
	//handler is used to create admin object and forward to adminform.jsp
	public ModelAndView addAdmin() {
		Admin admin = new Admin();
		ModelAndView mav = new ModelAndView();
		mav.addObject("adminobj", admin);
		mav.setViewName("Adminform");
		return mav;
	}
	
	@RequestMapping("/saveadmin")
	//handler used to save admin details into database
	public ModelAndView saveAdmin(@ModelAttribute("adminobj")Admin admin) {
		dao.saveAdmin(admin);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Account created successfull");
		mav.setViewName("Adminlogin");
		return mav;
		
	}
	
	@RequestMapping("/adminloginvalidate")
	//handler used to perform login validation for admin
	public ModelAndView loginValidation(ServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Admin admin = dao.login(email, password);
		
		if(admin != null) {
			session.setAttribute("admininfo", admin);
			ModelAndView mav = new ModelAndView();
			mav.addObject("message", "LoggedIn successfully");
			mav.setViewName("adminoptions");
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("message", "Invalid Credential");
			mav.setViewName("Adminlogin");
			return mav;
		}
	}
	
	


}
