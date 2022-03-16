package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.Study;

/**
 * Servlet implementation class DeleteRegisterCourseServlet
 */
@WebServlet("/DeleteRegisterCourseServlet")
public class DeleteRegisterCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRegisterCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("deleteButton")!=null) {
			String []ids = request.getParameterValues("idDelete");
			int studentID = Integer.parseInt(request.getParameter("studentID"));
			PrintWriter out = response.getWriter();
			if(studentID !=-1 && ids != null) {
				for(int i = 0; i<ids.length; i++) {
					Study std = new Study(studentID, Integer.parseInt(ids[i]));
					//out.print("Student ID: " + studentID);
					//out.print("Course ID: " + ids[i]);
					std.delete();
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
