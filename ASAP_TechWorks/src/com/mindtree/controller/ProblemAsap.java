package com.mindtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.Problem;
import com.mindtree.service.IAdminService;
import com.mindtree.validator.ProblemValidator;

@Controller
@RequestMapping("/AddProblem.action")
public class ProblemAsap {

	@Autowired
	private IAdminService adminService;

	@Autowired
	ProblemValidator problemValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String initProcess(ModelMap map) {
		Problem problem = new Problem();
		map.addAttribute("problem", problem);
		return "addproblem";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("problem") Problem problem,
			BindingResult errors, ModelMap map) {
		String target = "adminHome";
		problemValidator.validate(problem, errors);
		if (errors.hasErrors()) {
			target = "addproblem";
		} else {
			try {
				System.out.println("desc : " + problem.getDescription());
				
				adminService.addProblem(problem);
				map.addAttribute("message",
						"The problem statement has been added successfully");
			} catch (ServiceException exception) {
				map.addAttribute("errorMessage",exception.getMessage());
				target = "addproblem";
				exception.printStackTrace();
			}
		}
		return target;
	}
}
