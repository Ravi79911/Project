package com.nt.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_dependent")
public class EmployeeDependent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_master_id")
    private EmployeeMaster employeeMaster;

    @Column(name = "dependent_name")
    private String dependentName;

    @Column(name = "relation")
    private String relation;

    @Column(name = "aadhaar_no")
    private String aadhaarNo;

    public EmployeeDependent() {}

    public EmployeeDependent(Long id, EmployeeMaster employeeMaster, String dependentName, String relation, String aadhaarNo) {
        this.id = id;
        this.employeeMaster = employeeMaster;
        this.dependentName = dependentName;
        this.relation = relation;
        this.aadhaarNo = aadhaarNo;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeMaster getEmployeeMaster() {
		return employeeMaster;
	}

	public void setEmployeeMaster(EmployeeMaster employeeMaster) {
		this.employeeMaster = employeeMaster;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

    
}
