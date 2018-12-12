package com.app.spring.app;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserDepartment {
	

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="departmentId", nullable = false)
	private Long userDepartmentId;
	private String departmentName;
	private String departmentLocation;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	
	public UserDepartment() {
		super();
	}
	
	public UserDepartment(Long userDepartmentId, String departmentName, String departmentLocation) {
		super();
		this.userDepartmentId = userDepartmentId;
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}
	public Long getUserDepartmentId() {
		return userDepartmentId;
	}
	public void setUserDepartmentId(Long userDepartmentId) {
		this.userDepartmentId = userDepartmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
