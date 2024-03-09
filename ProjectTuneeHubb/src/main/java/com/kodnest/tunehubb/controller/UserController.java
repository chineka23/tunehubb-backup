package com.kodnest.tunehubb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehubb.entity.Song;
import com.kodnest.tunehubb.entity.User;
import com.kodnest.tunehubb.service.SongService;
import com.kodnest.tunehubb.serviceimpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl serviceImpl;
	@Autowired
	SongService songService;
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {
		//email taken from registration form
		String email = user.getEmail();

		//checking if email as entered in regisration form is present in db or not
		boolean status = serviceImpl.emailExists(email);
		if (status== false) {
			serviceImpl.addUser(user);
			System.out.println("User added");
		}
		else {
			System.out.println("User already exists");
		}
		return "login";

	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email")String email,
			@RequestParam("password")String password, HttpSession session, Model model) {
		if(serviceImpl.validateUser(email,password)==true) {
			String role = serviceImpl.getRole(email);
			session.setAttribute("email",email);
			if(role.equals("admin")){
				return "adminhome";
			}

			else {
				User user=serviceImpl.getUser(email);
				boolean userstatus=user.isIspremium();
				List<Song> fetchAllSongs =songService.fetchAllSongs();
				model.addAttribute("songs",fetchAllSongs);
				model.addAttribute("ispremium" , userstatus);
				return "customerhome";
			}
		}
		else {
			return "login";
		}}
		@PostMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "login";
		

	}

}
