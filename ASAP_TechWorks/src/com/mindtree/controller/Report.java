package com.mindtree.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.AssessmentReport;
import com.mindtree.model.AssessmentSchedule;
import com.mindtree.model.Problem;
import com.mindtree.service.AdminServiceImpl;
import com.mindtree.service.IAdminService;

/**
 * Servlet implementation class Report
 */
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) {
		int problemId = 0;
		String problemIdstr = "";
		String problemIdString="";
		problemIdstr = request.getParameter("problemId");
		problemIdString=problemIdstr.substring(0, problemIdstr.length()-8);
		System.out.println("problem id : " + problemIdString);
		
		if (!problemIdString.isEmpty() || problemIdString != " " || problemIdString!=null) {
			problemId = Integer.parseInt(problemIdString);
		}

		IAdminService adminService = new AdminServiceImpl();
		Date startDate = new Date();
		Date endDate = new Date();
		AssessmentSchedule assessmentSchedule = new AssessmentSchedule();
		List<AssessmentReport> assessmentReports = new ArrayList<AssessmentReport>();
		Problem problem = new Problem();
		String date = request.getAttribute("startDate").toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-mm");
		try {
			startDate = dateFormat.parse(date);
			date = request.getAttribute("endDate").toString();
			endDate = dateFormat.parse(date);
			problem.setProblemId(problemId);
			assessmentSchedule.setProblem(problem);
			assessmentSchedule.setStartDate(startDate);
			assessmentSchedule.setEndDate(endDate);
			assessmentReports = adminService
					.getAssessmentReport(assessmentSchedule);

			for (AssessmentReport report : assessmentReports) {
				System.out.println(report);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
