package SpringBootApplication.Controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SpringBootApplication.dao.*;
import SpringBootApplication.entities.*;

@Controller
public class HotelController {
	@Autowired
	HotelDao dao;

	@RequestMapping("/addhotel")
	// handler used to create hotel class Object and pass it to HotelForm.jsp
	public ModelAndView addhotel() {
		Hotel hotel = new Hotel();
		ModelAndView mav = new ModelAndView();
		mav.addObject("hotelobj", hotel);
		mav.setViewName("HotelForm");
		return mav;
	}

	@RequestMapping("/savehotel")
	// handler used to save Hotel information in database.
	public ModelAndView saveHotel(@ModelAttribute("hotelobj") Hotel hotel) {
		hotel.setStatus("Not Approved");
		dao.saveHotel(hotel);

		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Your account is in review, please wait for sometime");
		mav.setViewName("HotelLogin");
		return mav;
	}

	@RequestMapping("/hotelloginvalidate")
	// handler used to perform hotel login validation and return appropriate
	// response
	public ModelAndView loginValidation(ServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Hotel hotel = dao.login(email, password);

		if (hotel != null) {
			if (hotel.getStatus().equals("Not approved")) {
				ModelAndView mav = new ModelAndView();
				mav.addObject("message", "Your account is in review,please wait for sometime");
				mav.setViewName("displaymessage");
				return mav;
			} else if (hotel.getStatus().equals("blocked")) {
				ModelAndView mav = new ModelAndView();
				mav.addObject("message", "Your account is blocked");
				mav.setViewName("displaymessage");
				return mav;
			} else {
				//storing hotel entity object into session
				//storing the logged in hotel into session
				session.setAttribute("hotelinfo", hotel.getId());
				ModelAndView mav = new ModelAndView();
				mav.addObject("message", "Logged in successfully");
				mav.setViewName("hoteloptions");
				return mav;

			}
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("message", "Invalid Credentials");
			mav.setViewName("HotelLogin");
			return mav;
		}
	}
	
	@RequestMapping("/fetchunapprovedhotels")
	// handler is used to return unapproved hotels
	public ModelAndView fetchUnapprovedHotels() {
		List<Hotel> hotels = dao.findUnapprovedHotels();
		ModelAndView mav = new ModelAndView();
		mav.addObject("unapprovedhotels", hotels);
		mav.setViewName("displayunapprovedhotels");
		return mav;
	}
	
	@RequestMapping("/approvehotel")
	//handler is used to modify the hotel status as approved
	public ModelAndView approveHotel(@RequestParam("id")int id) {
		Hotel h = dao.findById(id);
		h.setStatus("approved");
		dao.updateHotel(h);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect://fetchapprovedhotels");
		return mav;
	}
	
	@RequestMapping("/adminlogout")
	//handler is used to delete the admin data in  Httpsession
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Logged out successfully");
		mav.setViewName("Adminhome");
		return mav;
	}


}
