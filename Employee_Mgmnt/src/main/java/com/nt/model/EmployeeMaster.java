package com.nt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee_master")
public class EmployeeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_code")
    private String employeeCode;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "employee_father_name")
    private String employeeFatherName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;
    
    @Column(name = "status", nullable = false)
    private int status = 1;

    @OneToMany(mappedBy = "employeeMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<EmployeeDependent> dependents = new ArrayList<>();

    @OneToMany(mappedBy = "employeeMaster", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeePersonalDetails> personalDetails = new ArrayList<>();

    // Default constructor
    public EmployeeMaster() {}

    // Parameterized constructor
    public EmployeeMaster(Long id, String employeeCode, String employeeName, String employeeFatherName,
			Date createdDate, int status, List<EmployeeDependent> dependents,
			List<EmployeePersonalDetails> personalDetails) {
		super();
		this.id = id;
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.employeeFatherName = employeeFatherName;
		this.createdDate = createdDate;
		this.status = status;
		this.dependents = dependents;
		this.personalDetails = personalDetails;
	}


    // Getters and Setters
    public Long getId() {
        return id;
    }

   
	public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeFatherName() {
        return employeeFatherName;
    }

    public void setEmployeeFatherName(String employeeFatherName) {
        this.employeeFatherName = employeeFatherName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
 
    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
    public List<EmployeeDependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<EmployeeDependent> dependents) {
        this.dependents = dependents;
    }

    public List<EmployeePersonalDetails> getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(List<EmployeePersonalDetails> personalDetails) {
        this.personalDetails = personalDetails;
    }
}
