package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product;

/**
 * Servlet implementation class Deleteproductype
 */
@WebServlet("/Deleteproductype")
public class Deleteproductype extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleteproductype() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("deleteButton")!=null) {
			String []ids = request.getParameterValues("idDelete");
			if(ids != null) {
				for(int i = 0; i<ids.length; i++) {
					product pt = new product(Integer.parseInt(ids[i]));
					pt.delete();
				}
			}
			response.sendRedirect("listCourseType.jsp");
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
