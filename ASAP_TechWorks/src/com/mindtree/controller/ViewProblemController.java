/**
 * 
 */
package com.mindtree.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.compiler.CompilerAPITest;
import com.mindtree.exception.ServiceException;
import com.mindtree.model.Candidate;
import com.mindtree.model.CompilerResult;
import com.mindtree.model.Problem;
import com.mindtree.model.Score;
import com.mindtree.model.Solution;
import com.mindtree.model.TestCase;
import com.mindtree.service.IAdminService;
import com.mindtree.service.ITestTakerService;
import com.mindtree.validator.SolutionValidator;

/**
 * @author m1012773
 * 
 */
@Controller
public class ViewProblemController {

	@Autowired
	ITestTakerService testTakerService;

	@Autowired
	IAdminService adminService;

	@Autowired
	SolutionValidator solutionValidator;

	@RequestMapping(method = RequestMethod.GET, value = "/ViewProblem.action")
	public String initProcess(ModelMap map, HttpServletRequest request) {

		int problemId = Integer.parseInt(request.getParameter("problemId"));
		System.out.println(problemId);
		try {
			Problem problem = new Problem();
			problem = adminService.getProblemById(problemId);

			Solution solution = new Solution();
			solution.setProblem(problem);

			map.addAttribute("solution", solution);
			map.addAttribute("problem", problem);
			System.out.println(problem);
		} catch (ServiceException e) {
			map.addAttribute("errorMessage", e.getMessage());
		}
		return "showProblem";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/SubmitSolution.action")
	public String processSubmit(@ModelAttribute("solution") Solution solution,
			BindingResult errors, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String target = "showProblem";
		System.out.println("Method Called");
		solutionValidator.validate(solution, errors);

		HttpSession session = request.getSession();
		int userId = Integer
				.parseInt(session.getAttribute("userId").toString());
		Candidate candidate = new Candidate();
		try {
			candidate = adminService.getCandidateByUserId(userId);
			solution.setCandidate(candidate);
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}

		if (errors.hasErrors()) {
			target = "showProblem";
		} else {
			String filename = "C:\\Users\\m1005676\\workspace\\ASAP_TechWorks\\src\\test\\"
					+ solution.getCandidate().getEmployeeId() + ".java";
			File sourceFile = new File(filename);
			try {
				FileUtils.writeStringToFile(sourceFile, "package test;\n"
						+ solution.getSourceCode());
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (request.getParameter("command").equals("Save Solution")) {
				try {

					solution.setFilename(filename);
					Date submitDate = new Date();
					//have changed database column type to varchar
					SimpleDateFormat submitDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					solution.setSubmittedOn(submitDate);
					testTakerService.submitSolution(solution);
					target = "testTakerHome";
					model.addAttribute("message", "Your solution has been submitted successfully");
				} catch (ServiceException e) {
					e.printStackTrace();
					target = "showProblem";
					model.addAttribute("message", e.getMessage());
				}
			} else if (request.getParameter("command").equals("Compile & Execute")||request.getParameter("command").equals("Submit Solution")) {
				try {
					CompilerResult compilerResult = new CompilerResult();
					List<TestCase> testcases = testTakerService.getTestCasesForProblem(solution.getProblem().getProblemId());

					compilerResult = CompilerAPITest.compileCode(sourceFile, testcases);

					if ("Failure".equals(compilerResult.getSolution().getComplierState())) {
						request.setAttribute("error", compilerResult.getErrorMessage());
					}

					request.setAttribute("testcase", compilerResult
							.getTestCases());
					if(request.getParameter("command").equals("Submit Solution")){
						try {
							solution.setFilename(filename);
							solution.setComplierState(compilerResult.getSolution().getComplierState());
							solution.setCompilerError(compilerResult.getSolution().getCompilerError());
							Date submitDate = new Date();
							//have changed database column type to varchar
							SimpleDateFormat submitDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
							solution.setSubmittedOn(submitDate);
							testTakerService.submitSolution(solution);
							
							Score score = new Score();
							score.setCandidate(solution.getCandidate());
							score.setProblem(solution.getProblem());
							score.setTotalScore(compilerResult.getScore().getTotalScore());
							
							testTakerService.submitScore(score);
							
							target = "testTakerHome";
							model.addAttribute("message", "Your solution has been submitted successfully");
							return target;
						} catch (ServiceException e) {
							e.printStackTrace();
							target = "showProblem";
							model.addAttribute("message", e.getMessage());
						}
					}
				//	return "result";
					return target;

				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return target;
	}
}
