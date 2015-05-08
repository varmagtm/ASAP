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
import com.mindtree.model.AssessmentReport;
import com.mindtree.model.AssessmentSchedule;
import com.mindtree.model.Problem;
import com.mindtree.service.IAdminService;
import com.mindtree.validator.AssessmentScheduleValidator;

/**
 * @author M1012679
 * 
 */
@Controller
public class AssessmentReportController {

	@Autowired
	IAdminService adminService;

	@Autowired
	AssessmentScheduleValidator assessmentScheduleValidator;

	@RequestMapping(method = RequestMethod.GET, value = "/ViewAssessmentReports.action")
	public String initForm(ModelMap model) {
		AssessmentSchedule assessmentSchedule = new AssessmentSchedule();
		assessmentSchedule.setStartDate(new Date());
		assessmentSchedule.setEndDate(new Date());
		model.addAttribute("assessmentSchedule", assessmentSchedule);
		return "assessmentReport";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/ViewAssessmentReports.action")
	public String viewReport(
			@ModelAttribute("assessmentSchedule") AssessmentSchedule assessmentSchedule,
			BindingResult errors, ModelMap model) {
		String target = "assessmentReport";
		List<AssessmentReport> assessmentReports = new ArrayList<AssessmentReport>();
		assessmentScheduleValidator.validate(assessmentSchedule, errors);
		if (errors.hasErrors()) {
			model
					.addAttribute("message",
							"Error : Could not generate the report!");
		} else {
			try {
				System.out.println(assessmentSchedule);

				if (assessmentSchedule.getProblem().getProblemId() == 0) {
					assessmentReports = adminService.getAllAssessmentReport();
				} else {
					assessmentReports = adminService
							.getAssessmentReport(assessmentSchedule);
				}
				model.addAttribute("reports", assessmentReports);
				model.addAttribute("assessmentSchedule", assessmentSchedule);
				model.addAttribute("numberOfMatches", assessmentReports.size());
				target = "viewAssessmentReport";
			} catch (ServiceException e) {
				e.printStackTrace();
				target = "assessmentReport";
				model.addAttribute("message", e.getMessage());
			}
		}

		return target;
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
}
