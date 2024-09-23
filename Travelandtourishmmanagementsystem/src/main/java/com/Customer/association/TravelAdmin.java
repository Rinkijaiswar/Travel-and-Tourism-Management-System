package com.Customer.association;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity

public class TravelAdmin {
	@Id
	private String admId;
	@Column(length = 20)
	private String admName;
	private double salary;
	
	//one to one relationship-one employee can have one address
	
	@OneToOne
	@JoinColumn(name = "travelpackage_id")
	TravelPackage travelpackage;  //travelpackage_travelpackageId

	public String getadmId() {
		return admId;
	}

	public void setAdmId(String admId) {
		this.admId = admId;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public TravelPackage getAddress() {
		return travelpackage;
	}

	public void setTravelPackage(TravelPackage travelpackage) {
		this.travelpackage = travelpackage;
	}

	public TravelAdmin(String admId, String admName, double salary, TravelPackage travelpackage) {
		super();
		this.admId = admId;
		this.admName = admName;
		this.salary = salary;
		this.travelpackage = travelpackage;
	}

	public TravelAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TravelAdmin [admId=" + admId + ", admName=" + admName + ", salary=" + salary + ", travelpackage=" + travelpackage+ "]";
	}


}
