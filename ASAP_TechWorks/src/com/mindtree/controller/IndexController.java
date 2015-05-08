/**
 * 
 */
package com.mindtree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author m1012679
 * 
 */
@Controller
public class IndexController {

	@RequestMapping("/Welcome.action")
	public String initForm() {
		return "welcome";
	}
	
	@RequestMapping("/DisplayImage.action")
	public String displayImage() {
		return "displayImage";
	}

	@RequestMapping("/LoginRegister.action")
	public String showLoginRegister() {
		return "loginRegister";
	}
	@RequestMapping("/AboutASAP.action")
	public String aboutASAP() {
		return "aboutASAP";
	}

	@RequestMapping("/Register.action")
	public String register() {
		return "resgister";
	}
}
