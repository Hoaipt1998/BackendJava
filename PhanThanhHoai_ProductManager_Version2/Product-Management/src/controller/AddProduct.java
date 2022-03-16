package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

/**
 * Servlet implementation class Addproduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("addButton")!=null) {
			String description = request.getParameter("description");
			Double price =Double.parseDouble(request.getParameter("price"));
			String name = request.getParameter("name");
			String status = request.getParameter("status");
			int productTypeID = Integer.parseInt(request.getParameter("id"));
			Product pt = new Product(name, price, description, status,productTypeID);
			
			pt.insert();
			request.setAttribute("message", "Add product:<b>" + name +  "</b> Successful!");
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
