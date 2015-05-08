/**
 * 
 */
package com.mindtree.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
import com.mindtree.model.Candidate;
import com.mindtree.model.Group;
import com.mindtree.model.User;

import com.mindtree.service.IAdminService;
import com.mindtree.validator.CandidateValidator;

/**
 * @author m1012776 Adds a candidate
 */
@Controller
@RequestMapping("/AddCandidate.action")
public class CandidateController {

	@Autowired
	private IAdminService adminService;

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap map) {
		Candidate candidate = new Candidate();
		map.addAttribute("candidate", candidate);
		return "candidateForm";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("candidate") Candidate candidate,
			BindingResult errors, ModelMap map, HttpServletRequest request) {
		String target = "adminHome";
		CandidateValidator candidateValidator = new CandidateValidator();
		candidateValidator.validate(candidate, errors);
		if (errors.hasErrors()) {
			target = "candidateForm";

		} else {
			try {
				//HttpSession session = request.getSession();
				
				User user = new User();
				user.setUsername(candidate.getEmployeeId());
				user.setPassword(candidate.getEmployeeId());
				user.setIsAdmin(false);
				user.setIpAddress(request.getRemoteHost());
				
				User user1 = new User();
				user1 = adminService.addUser(user);
				
				candidate.setUser(user1);
				candidate.setGroup(adminService.getGroupById(candidate
						.getGroup().getGroupId()));
				
				adminService.addCandidate(candidate);
				map.addAttribute("message", "The candidate has been added!");
			} catch (ServiceException e) {
				target = "candidateForm";
				map.addAttribute("message", e.getMessage());
			}
		}
		return target;
	}

	@ModelAttribute("groupList")
	public Map<Integer, String> populateGroups(ModelMap map) {
		Map<Integer, String> groupMap = new LinkedHashMap<Integer, String>();
		List<Group> groups = new ArrayList<Group>();
		try {
			groups = adminService.getAllGroups();

			for (Group group : groups) {
				groupMap.put(group.getGroupId(), group.getName());
			}
		} catch (ServiceException e) {
			map.addAttribute("errorMessage", e.getMessage());
			e.printStackTrace();
		}
		return groupMap;
	}
}
