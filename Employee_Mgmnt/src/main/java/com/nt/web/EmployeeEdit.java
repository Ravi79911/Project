package com.nt.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.EmployeeMasterDAO;
import com.nt.dao.EmployeePersonalDetailsDAO;
import com.nt.model.EmployeeMaster;
import com.nt.model.EmployeePersonalDetails;

/**
 * Servlet implementation class EmployeeEdit
 */
@WebServlet("/editEmployee")
public class EmployeeEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		if(idStr != null) {
			long id = Integer.parseInt(idStr);
			
			EmployeePersonalDetailsDAO employeePersonalDao = new EmployeePersonalDetailsDAO();
			EmployeePersonalDetails empPersonalDetails = employeePersonalDao.getEmployeeById(id);
		
			 if(empPersonalDetails != null) {
				 request.setAttribute("empPersonalDetails", empPersonalDetails);
				 try {
					 EmployeeMasterDAO empMSDao=new EmployeeMasterDAO();
					 EmployeeMaster empMaster=empMSDao.getEmployeeById(id);
					 request.setAttribute("empMaster", empMaster);
					 
					 
				 }catch(Exception e) {
					 e.printStackTrace();
				 }
              
	            request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
			 }
			 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String idStr = request.getParameter("id");
		
		String fullName = request.getParameter("fullName");
        String fatherName = request.getParameter("fatherName");
        String motherName = request.getParameter("motherName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        
       
        String communicationHouse = request.getParameter("communicationHouse");
        String communicationStreet = request.getParameter("communicationStreet");
        String communicationLandmark = request.getParameter("communicationLandmark");
        String communicationCity = request.getParameter("communicationCity");
        String communicationDistrict = request.getParameter("communicationDistrict");
        String communicationState = request.getParameter("communicationState");
        String communicationPin = request.getParameter("communicationPin");
        
        if(idStr != null) {
			long id = Integer.parseInt(idStr);
          EmployeeMasterDAO empMasterDAO=new EmployeeMasterDAO();
          EmployeeMaster empMaster=empMasterDAO.getEmployeeById(id);
          if(empMaster !=null) {
          empMaster.setEmployeeName(fullName);
          empMaster.setEmployeeFatherName(fatherName);
          empMaster.setCreatedDate(new Date());
          
          empMasterDAO.updateEmployee(empMaster);}
           
         EmployeePersonalDetailsDAO employeePersonalDetailsDAO=new EmployeePersonalDetailsDAO();
         EmployeePersonalDetails personalDetails=employeePersonalDetailsDAO.getEmployeeById(id);
         
    	   personalDetails.setEmployeeMaster(empMaster);
           personalDetails.setFatherName(fatherName);
           personalDetails.setMotherName(motherName);
           personalDetails.setEmail(email);
           personalDetails.setPhone(phone);
           personalDetails.setGender(gender);
           personalDetails.setCommunicationHouse(communicationHouse);
           personalDetails.setCommunicationStreet(communicationStreet);
           personalDetails.setCommunicationLandmark(communicationLandmark);
           personalDetails.setCommunicationCity(communicationCity);
           personalDetails.setCommunicationDistrict(communicationDistrict);
           personalDetails.setCommunicationState(communicationState);
           personalDetails.setCommunicationPin(communicationPin);
          
           employeePersonalDetailsDAO.updateEmployee(personalDetails);
      
		}
		 response.sendRedirect("edit_success.jsp");
	}
	}
	
