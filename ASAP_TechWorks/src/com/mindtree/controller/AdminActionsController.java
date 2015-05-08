/**
 * 
 */
package com.mindtree.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.AssessmentSchedule;
import com.mindtree.model.Group;
import com.mindtree.model.Problem;
import com.mindtree.service.IAdminService;
import com.mindtree.validator.AssessmentScheduleValidator;

/**
 * @author m1012679
 * 
 */
@Controller
public class AdminActionsController {

	@Autowired
	IAdminService adminService;

	@Autowired
	AssessmentScheduleValidator assessmentScheduleValidator;

	@RequestMapping(method = RequestMethod.POST, value = "/ScheduleAssessment.action")
	public String processSubmit(
			@ModelAttribute("assessmentSchedule") AssessmentSchedule assessmentSchedule,
			BindingResult errors, Model model) {
		String target = "adminHome";

		assessmentScheduleValidator.validate(assessmentSchedule, errors);
		if (errors.hasErrors()) {
			target = "scheduleAssessment";
		} else {

			try {
				assessmentSchedule.setEnable(false);
				adminService.scheduleAssessment(assessmentSchedule);
				model.addAttribute("message", "The assessment has been scheduled");
			} catch (ServiceException e) {
				e.printStackTrace();
				target = "scheduleAssessment";
				model.addAttribute("message", e.getMessage());
			}
		}
		return target;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/ScheduleAssessment.action")
	public String initForm(ModelMap model) {
		AssessmentSchedule assessmentSchedule = new AssessmentSchedule();
		assessmentSchedule.setEnable(false);
		assessmentSchedule.setStartDate(new Date());
		assessmentSchedule.setEndDate(new Date());
		assessmentSchedule.setScheduleId(1);
		model.addAttribute("assessmentSchedule", assessmentSchedule);
		return "scheduleAssessment";
	}

	@ModelAttribute("groups")
	public Map<Integer, String> populateGroups(Model model) {
		Map<Integer, String> groupsList = new LinkedHashMap<Integer, String>();
		List<Group> groups = new ArrayList<Group>();
		try {
			groups = adminService.getAllGroups();
			for (Group group : groups) {
				groupsList.put(group.getGroupId(), group.getName());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}
		return groupsList;
	}

	@ModelAttribute("problems")
	public Map<Integer, String> populateProblems(Model model) {
		Map<Integer, String> problemsList = new LinkedHashMap<Integer, String>();
		List<Problem> problems = new ArrayList<Problem>();
		try {
			problems = adminService.getAllProblems();
			for (Problem problem : problems) {
				problemsList.put(problem.getProblemId(), problem.getName());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}
		return problemsList;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/AdminHome.action")
	public String adminHomeForm(ModelMap model) {
		return "adminHome";
	}
}
