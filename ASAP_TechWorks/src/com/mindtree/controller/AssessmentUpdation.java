package com.mindtree.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.AssessmentSchedule;
import com.mindtree.model.Group;
import com.mindtree.model.Problem;
import com.mindtree.service.IAdminService;

@Controller
@RequestMapping("/UpdateAssessment.action")
public class AssessmentUpdation {

	@Autowired
	private IAdminService adminService;

	@RequestMapping(method = RequestMethod.GET)
	public String initProcess(ModelMap map) {
		AssessmentSchedule assessmentSchedule = new AssessmentSchedule();
		map.addAttribute("update", assessmentSchedule);
		return "updateassessment";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("update") AssessmentSchedule assessmentSchedule,
			BindingResult errors, ModelMap map, HttpServletRequest request) {
		String target = "adminHome";
		try {
			int problemId = Integer.parseInt(request.getParameter("problem"));
			Problem problem = new Problem();
			problem.setProblemId(problemId);
			assessmentSchedule.setProblem(problem);
			assessmentSchedule.setScheduleId(adminService.getScheduleId(assessmentSchedule));
			System.out.println(assessmentSchedule);
			adminService.updateAssessment(assessmentSchedule);
			map.addAttribute("message", "The assessment has been updated");
		} catch (ServiceException exception) {
			map.addAttribute("message", "The assessment could not be updated");
			target = "updateassessment";
			exception.printStackTrace();
		}

		return target;

	}

	@ModelAttribute("groups")
	public Map<Integer, String> getAllGroups(ModelMap map) {
		Map<Integer, String> groups = new HashMap<Integer, String>();
		List<Group> groupList = null;
		try {
			groupList = (List<Group>) adminService.getAllGroups();
			for (Group group : groupList) {
				groups.put(group.getGroupId(), group.getName());
			}
		} catch (ServiceException exception) {
			exception.printStackTrace();
		}

		return groups;
	}

}
