package com.sunil__parcha.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.el.stream.Stream;
import com.sunil__parcha.modal.Role;
import com.sunil__parcha.modal.User;
import com.sunil__parcha.repository.RoleRepo;
//import com.sunil__parcha.repository.RoleRepo;
import com.sunil__parcha.repository.UserRepo;


@Controller
public class AuthenticationController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roles;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		 modelAndView.addObject("user", new User()); 
		modelAndView.setViewName("register"); // resources/template/register.html
		return modelAndView;
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("user") User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	    Role userRole = roles.findById(2);
//		Set<Role> roles1 = Stream.(userRole)
//                .collect(Collectors.toCollection(HashSet::new));
	    Set<Role> roles1 = new HashSet<Role>();
	    roles1.add(userRole);
//		System.out.println(user.getRoles().toString());
	    
		user.setRoles(roles1);
		userRepo.save(user);
		return "redirect:/login";
		
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home"); // resources/template/home.html
		return modelAndView;
	}
}