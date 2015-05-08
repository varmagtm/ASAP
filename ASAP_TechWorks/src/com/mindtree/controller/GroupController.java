/**
 * 
 */
package com.mindtree.controller;

import java.util.ArrayList;
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
import com.mindtree.model.Candidate;
import com.mindtree.model.Group;
import com.mindtree.service.IAdminService;
import com.mindtree.validator.GroupValidator;

/**
 * @author m1012776 Adds the group
 */
@Controller
public class GroupController {
	@Autowired
	private IAdminService adminService;

	@RequestMapping(method = RequestMethod.GET, value = "/CreateGroup.action")
	public String initForm(ModelMap map) {
		Group group = new Group();
		map.addAttribute("group", group);
		return "groupForm";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/CreateGroup.action")
	public String processSubmit(@ModelAttribute("group") Group group,
			BindingResult errors, ModelMap map) {
		String target = "adminHome";
		GroupValidator groupValidator = new GroupValidator();
		groupValidator.validate(group, errors);
		if (errors.hasErrors()) {
			target = "groupForm";
		} else {
			try {
				adminService.addGroup(group);
				map.addAttribute("message", "The group has been added");
			} catch (ServiceException e) {
				target = "groupForm";
				System.out.println("ERROR : " + e.getMessage());
				map.addAttribute("errorMessage", e.getMessage());
			}
		}
		return target;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/AssociateGroupWithCandidate.action")
	public String initACGForm(ModelMap map) {
		Candidate candidate = new Candidate();
		map.addAttribute("candidate", candidate);
		return "associateCandidateGroup";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/AssociateGroupWithCandidate.action")
	public String processSubmitAGC(
			@ModelAttribute("candidate") Candidate candidate,
			BindingResult errors, ModelMap map) {
		String target = "adminHome";
		try {
			Candidate candidate1 = new Candidate();
			Group group = new Group();
			group = adminService
					.getGroupById(candidate.getGroup().getGroupId());
			candidate1 = adminService.getCandidateById(candidate
					.getCandidateId());
			candidate1.setGroup(group);

			System.out.println("Candidate : " + candidate1);

			adminService.associateCandidateWithGroup(candidate1);
			map.addAttribute("message", "The candidate has been associated with the group!");
		} catch (ServiceException e) {
			target = "associateCandidateGroup";
			System.out.println("ERROR : " + e.getMessage());
			map.addAttribute("errorMessage", e.getMessage());
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

	@ModelAttribute("candidates")
	public Map<Integer, String> getAllCandidates(ModelMap map) {
		Map<Integer, String> candidates = new HashMap<Integer, String>();
		List<Candidate> candidatesList = new ArrayList<Candidate>();
		try {
			candidatesList = (List<Candidate>) adminService.getAllCandidates();
			for (Candidate candidate : candidatesList) {
				candidates.put(candidate.getCandidateId(), candidate.getName()
						+ " - " + candidate.getEmployeeId());
			}
		} catch (ServiceException exception) {
			exception.printStackTrace();
		}
		return candidates;
	}

}
