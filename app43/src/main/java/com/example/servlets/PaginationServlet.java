package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.Employee;
import com.example.service.EmployeeService;


@WebServlet("/pagination")
public class PaginationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 EmployeeService empService=null;
	 
	@Override
	public void init() throws ServletException {
		empService=new EmployeeService();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String label=request.getParameter("button");
		System.out.println(label);
		
		List<Employee>empList=empService.getEmployees(label);
		System.out.println(empList.isEmpty()+"PAgination"+empList.size());
		out.println("<html>");
		out.println("<body>");
		out.println("<h2 style='color:red;' align='center'>EMployee Details</h2> ");
		out.println("<center>");
		out.println("<table border='1'> ");
		out.println("<tr><th>ENO</th><th>ENAME</th><th>ESAL</th><th>EADDR</th></tr>");
		for(Employee emp:empList) {
			System.out.println(emp==null);
			out.println("<tr>");
			out.println("<td>"+emp.getEno()+"</td>");
			out.println("<td>"+emp.getEname()+"</td>");
			out.println("<td>"+emp.getEsal()+"</td>");
			out.println("<td>"+emp.getEaddr()+"</td>");
			out.println("</tr>");

		}
		
		
		out.println("</table></center></body></html>");
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("form.html");
		requestDispatcher.include(request, response);


		
	
	}

}
