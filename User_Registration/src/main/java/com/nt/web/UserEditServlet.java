package com.nt.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.UserDAO;
import com.nt.model.User;






/**
 * Servlet implementation class UserEditServlet
 */
@WebServlet("/editUser")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if(idStr != null) {
			long id = Long.parseLong(idStr);
			UserDAO userDao = new UserDAO();
			User user = userDao.findById(id);
		System.out.println(user);
				 
				 request.setAttribute("user", user);
				
				
				 request.getRequestDispatcher("editUser.jsp").forward(request, response);
			 }
		
		
			 }
			 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		
		String Name = request.getParameter("name");
        String email = request.getParameter("email");
        String Addrs = request.getParameter("addrs");
        
        if(idStr != null) {
			long id = Long.parseLong(idStr);
			UserDAO userDAO=new UserDAO();
          User user=userDAO.findById(id);
          if(user !=null) {
          user.setName(Name);
          user.setEmail(email);
          user.setAddrs(Addrs);
          
          userDAO.updateUser(user);}
      
		}
		 response.sendRedirect("edit_success.jsp");
	}
	
	}


