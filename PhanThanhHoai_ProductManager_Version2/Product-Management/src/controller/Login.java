package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
			String username=request.getParameter("name");  
			String password=request.getParameter("password");  
			if(Admin.Login(username, password)){  
				HttpSession session=request.getSession();  
				session.setAttribute("name",username);  
			    request.getRequestDispatcher("listProduct.jsp").include(request, response);  
			}  
			else{  
				request.setAttribute("message", "Sorry, username or password error!");
			    request.getRequestDispatcher("Login.jsp").include(request, response);  
			}  
    }
}
