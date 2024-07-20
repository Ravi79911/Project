package com.nt.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.EmployeeDependentDAO;
import com.nt.dao.EmployeeMasterDAO;
import com.nt.dao.EmployeePersonalDetailsDAO;
import com.nt.model.EmployeeDependent;
import com.nt.model.EmployeeMaster;
import com.nt.model.EmployeePersonalDetails;



@WebServlet("/register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Personal details
            String fullName = request.getParameter("fullName");
            String fatherName = request.getParameter("fatherName");
            String motherName = request.getParameter("motherName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");

            // Permanent address
            String permanentHouse = request.getParameter("permanentHouse");
            String permanentStreet = request.getParameter("permanentStreet");
            String permanentLandmark = request.getParameter("permanentLandmark");
            String permanentCity = request.getParameter("permanentCity");
            String permanentDistrict = request.getParameter("permanentDistrict");
            String permanentState = request.getParameter("permanentState");
            String permanentPin = request.getParameter("permanentPin");

            // Communication address
            String communicationHouse = request.getParameter("communicationHouse");
            String communicationStreet = request.getParameter("communicationStreet");
            String communicationLandmark = request.getParameter("communicationLandmark");
            String communicationCity = request.getParameter("communicationCity");
            String communicationDistrict = request.getParameter("communicationDistrict");
            String communicationState = request.getParameter("communicationState");
            String communicationPin = request.getParameter("communicationPin");

            // Family details
            String[] dependents = request.getParameterValues("dependentName");
            String[] relations = request.getParameterValues("relation");
            String[] aadhaars = request.getParameterValues("aadhaarNo");

            // Create and save EmployeeMaster
            EmployeeMaster employeeMaster = new EmployeeMaster();
            employeeMaster.setEmployeeName(fullName);
            employeeMaster.setEmployeeFatherName(fatherName);
            employeeMaster.setCreatedDate(new Date());

            EmployeeMasterDAO employeeMasterDAO = new EmployeeMasterDAO();
            EmployeeMaster savedEmployee = employeeMasterDAO.saveEmployeeMaster(employeeMaster);

            // Create and save EmployeePersonalDetails
            EmployeePersonalDetails personalDetails = new EmployeePersonalDetails();
            personalDetails.setEmployeeMaster(savedEmployee);
            personalDetails.setFatherName(fatherName);
            personalDetails.setMotherName(motherName);
            personalDetails.setEmail(email);
            personalDetails.setPhone(phone);
            personalDetails.setGender(gender);
            personalDetails.setPermanentHouse(permanentHouse);
            personalDetails.setPermanentStreet(permanentStreet);
            personalDetails.setPermanentLandmark(permanentLandmark);
            personalDetails.setPermanentCity(permanentCity);
            personalDetails.setPermanentDistrict(permanentDistrict);
            personalDetails.setPermanentState(permanentState);
            personalDetails.setPermanentPin(permanentPin);
            personalDetails.setCommunicationHouse(communicationHouse);
            personalDetails.setCommunicationStreet(communicationStreet);
            personalDetails.setCommunicationLandmark(communicationLandmark);
            personalDetails.setCommunicationCity(communicationCity);
            personalDetails.setCommunicationDistrict(communicationDistrict);
            personalDetails.setCommunicationState(communicationState);
            personalDetails.setCommunicationPin(communicationPin);

           EmployeePersonalDetailsDAO empDao=new EmployeePersonalDetailsDAO();
           empDao.saveEmployeePersonalDetails(personalDetails);

         // Create and save EmployeeDependents
            if (dependents != null && relations != null && aadhaars != null) {
                List<EmployeeDependent> dependentList = new ArrayList<>();
                for (int i = 0; i < dependents.length; i++) {
                    EmployeeDependent dependent = new EmployeeDependent();
                    dependent.setEmployeeMaster(savedEmployee);
                    dependent.setDependentName(dependents[i]);
                    dependent.setRelation(relations[i]);
                    dependent.setAadhaarNo(aadhaars[i]);
                    dependentList.add(dependent);
                }

                EmployeeDependentDAO dependentDAO = new EmployeeDependentDAO();
                dependentDAO.saveEmployeeDependents(dependentList);
            }


            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
