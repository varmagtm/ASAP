package com.mindtree.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.AssessmentSchedule;

import com.mindtree.service.ITestTakerService;

@Controller
@RequestMapping("/ViewAssignedAssessment.action")
public class ViewAssignedAssessmentController {

	@Autowired
	private ITestTakerService testTakerService;

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(HttpServletRequest request) {
		String target = "viewAssignedAssessments";
		return target;
	}

	@ModelAttribute("assessmentSchedule")
	public List<AssessmentSchedule> populateAssessmentSchedule(ModelMap map,HttpServletRequest request) {
		List<AssessmentSchedule> schedules = new ArrayList<AssessmentSchedule>();
		try {
			HttpSession session = request.getSession();
			int userId = Integer.parseInt(session.getAttribute("userId").toString());
			schedules = testTakerService.getAllAssignedAssessments(userId);
		} catch (ServiceException e) {
			map.addAttribute("errorMessage", e.getMessage());
			e.printStackTrace();
		}
		return schedules;
	}
}
