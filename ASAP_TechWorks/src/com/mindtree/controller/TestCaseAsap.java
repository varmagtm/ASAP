/**
 * 
 */
package com.mindtree.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.Problem;
import com.mindtree.model.TestCase;
import com.mindtree.service.IAdminService;
import com.mindtree.validator.TestCaseValidator;

/**
 * @author M1012718
 * 
 */

@Controller
@RequestMapping("/AddTestCase.action")
public class TestCaseAsap {

	@Autowired
	private IAdminService adminService;

	@Autowired
	TestCaseValidator testCaseValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String initProcess(ModelMap map) {
		TestCase testCase = new TestCase();
		map.addAttribute("testcase", testCase);
		return "addtestcase";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("testcase") TestCase testCase,
			BindingResult errors, ModelMap map) {
		String target = "adminHome";
		testCaseValidator.validate(testCase, errors);
		if (errors.hasErrors()) {
			target = "addtestcase";	
		} else {
			try {
				System.out.println("TC ..... : " + testCase);
				adminService.addTestCase(testCase);
				map.addAttribute("message", "The test case has been added successfully");
			} catch (ServiceException e) {
				e.printStackTrace();
				target = "addtestcase";
				map.addAttribute("errorMessage", e.getMessage());
			}
		}
		return target;
	}

	@ModelAttribute("problems")
	public Map<Integer, String> getAllProblems(ModelMap map) {
		Map<Integer, String> problems = new HashMap<Integer, String>();
		List<Problem> problemList = null;
		try {
			problemList = adminService.getAllProblems();
			if (problemList == null) {
				System.out.println("Empty");
			}
			for (Problem problem : problemList) {
				problems.put(problem.getProblemId(), problem.getName());
			}
		} catch (ServiceException exception) {
			exception.printStackTrace();
		}
		return problems;
	}

}
