package com.mindtree.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mindtree.exception.ServiceException;
import com.mindtree.model.Problem;
import com.mindtree.service.AdminServiceImpl;
import com.mindtree.service.IAdminService;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request,response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		List<Problem> problemList = new ArrayList<Problem>();
	
		System.out.println(request.getParameter("n"));
		
		IAdminService service = new AdminServiceImpl();
		try {
			problemList = service.getProblems(Integer.parseInt(request.getParameter("n")));
		} catch (NumberFormatException exception) {
			exception.printStackTrace();
		} catch (ServiceException exception) {
			exception.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		out.print("<select>");
		for(Problem problem:problemList){
		out.print("<option value=\""+problem.getProblemId()+"\">"+problem.getName()+"</option>");
		}
		out.print("</select");
		
	}

}
