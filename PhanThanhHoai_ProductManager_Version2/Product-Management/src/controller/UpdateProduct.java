package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

/**
 * Servlet implementation class Updateproduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("updateButton")!=null) {
			String description = request.getParameter("description");
			Double price =Double.parseDouble(request.getParameter("price"));
			String name = request.getParameter("name");
			String status = request.getParameter("status");
			int id = Integer.parseInt(request.getParameter("id"));
			int productTypeID = Integer.parseInt(request.getParameter("productType"));
			Product pt = new Product(id,name, price, description, status,productTypeID);
			pt.update();
			request.setAttribute("message", "Update product:<b>" + name +  "</b> Successful!");
		}
		request.getRequestDispatcher("listProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
