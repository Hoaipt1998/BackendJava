package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.CourseType;
import student.Student;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddStudentServlet() {
        super();
       
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("addButton")!=null) {
			String code = request.getParameter("code");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");

			Student student = new Student(code, firstName,lastName);
			student.insert();
		}
		response.sendRedirect("listStudent.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
