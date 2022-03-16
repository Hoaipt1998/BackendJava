package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.CourseType;

/**
 * Servlet implementation class UpdateCourseTypeServlet
 */
@WebServlet("/UpdateCourseTypeServlet")
public class UpdateCourseTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourseTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("updateButton")!=null) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			CourseType c = new CourseType(id, name, description);
			c.update();
		}
		response.sendRedirect("listCourseType.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
