package com.mindtree.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.Problem;
import com.mindtree.service.IAdminService;

@Controller
@RequestMapping("/update.action")
public class Update {

	@Autowired
	private IAdminService adminService;

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public void getProblem(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List problemList = null;
		List<Problem> problems = new ArrayList<Problem>();
		System.out.println("THIS METHOD IS CALLED");
		System.out.println(request.getParameter("n"));

		try {
			problemList = adminService.getProblems(Integer.parseInt(request
					.getParameter("n")));
			for (int i = 0; i < problemList.size(); i++) {
				Object[] objects = (Object[]) problemList.get(i);
				Problem problem = new Problem();
				problem.setProblemId((Integer) objects[0]);
				problem.setName((String) objects[1]);
				System.out.println("***********************************");
				System.out.println("problemid " + objects[0]);
				System.out.println("name " + objects[1]);
				System.out.println("***********************************");
				problems.add(problem);

			}
		} catch (NumberFormatException exception) {
			exception.printStackTrace();
		} catch (ServiceException exception) {
			exception.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		out.print("<select name=\"problem\" class=\"control\">");
		for (int i = 0; i < problems.size(); i++) {
			out.print("<option value=" + problems.get(i).getProblemId() + " class=\"control\">"
					+ problems.get(i).getName() + "</option>");
		}
		out.print("</select>");
	}
}
