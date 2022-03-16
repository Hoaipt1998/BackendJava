package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.Course;
import course.Study;

/**
 * Servlet implementation class RegisterCourseServlet
 */
@WebServlet("/RegisterCourseServlet")
public class RegisterCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("registerButton")!=null) {
			String []ids = request.getParameterValues("idRegister");
			int studentID = Integer.parseInt(request.getParameter("studentID"));
			
			if(studentID !=-1 && ids != null) {
				for(int i = 0; i<ids.length; i++) {
					Study std = new Study(studentID, Integer.parseInt(ids[i]));
					std.insert();
				}
			}
			response.sendRedirect("registerCourse.jsp?studentIDRedirect="+studentID);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
