/**
 * 
 */
package com.mindtree.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.exception.ServiceException;

import com.mindtree.service.IAdminService;

/**
 * @author m1012773
 * 
 */
@Controller
@RequestMapping("/importProblem.action")
public class ImportAssessmentController {

	@Autowired
	IAdminService adminService;

	@RequestMapping(method = RequestMethod.POST)
	public String initProcess(ModelMap map, HttpServletRequest request) {

		String fileLocation = request.getParameter("fileLocation");
		try {
			adminService.uploadFile(fileLocation);
		} catch (ServiceException e) {
			e.printStackTrace();
			map.addAttribute("message", e.getMessage());
			return "importAssessmentAdmin";
		}
		map.addAttribute("message", "The problem has been uploaded successfully");
		return "importAssessmentAdmin";

	}
}
