package com.nt.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.dao.EmployeeMasterDAO;
import com.nt.mgmt.HibernateUtil;
import com.nt.model.EmployeeMaster;

/**
 * Servlet implementation class EmployeeDelete
 */
@WebServlet("/employeeDelete")
public class EmployeeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if(idStr != null) {
			long id = Integer.parseInt(idStr);
			
			EmployeeMasterDAO employeeDao = new EmployeeMasterDAO();
			EmployeeMaster empMaster = employeeDao.getEmployeeById(id);
			
			if(empMaster != null) {
				empMaster.setStatus(0);
				
				employeeDao.updateEmployee(empMaster);
				
				 response.sendRedirect("success.jsp");
			}
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
