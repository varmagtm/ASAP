/**
 * 
 */
package com.mindtree.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.mindtree.exception.ServiceException;
import com.mindtree.model.User;
import com.mindtree.service.AuthenticationService;

/**
 * @author m1012679
 * 
 */
@Controller
public class LoginLogout {

	@Autowired
	AuthenticationService authenticationService;

	@RequestMapping(method = RequestMethod.POST, value = "/Login.action")
	public String processSubmit(@ModelAttribute("user") User user,
			BindingResult errors, Model model,HttpServletRequest request) {
		String target = "testTakerHome";

		try {
			User user2 = authenticationService.login(user);
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user2.getUsername());
			session.setAttribute("userId", user2.getUserId());
			if (user2.getIsAdmin()) {
				target = "adminHome";
			} else {
				target = "testTakerHome";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			target = "login";
			model.addAttribute("message", e.getMessage());
		}
		return target;
	}


	@RequestMapping(method = RequestMethod.GET, value = "/Login.action")
	public String initForm(ModelMap model) {
		User user = new User();
		user.setIsAdmin(true);
		model.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Logout.action")
	public String logout() {
		return "logout";
	}
}
