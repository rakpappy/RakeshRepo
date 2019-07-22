package com.cts.mytask.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name ="user")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="employee_id")
	private Integer employeeId;
	
	
	
	
	//@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonManagedReference(value="project_user_reference")
	private List<Project> projects;
	
	
	@OneToMany(mappedBy = "userTask", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "user_task_reference")
	private List<Task> tasks;
	
	

	@Transient
	private String actions;
	
	
	
	
	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}


	public String getActions() {
		return actions;
	}


	public void setActions(String actions) {
		this.actions = actions;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public Integer getEmployeeId() {
		return employeeId;
	}


	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


//	public List<Task> getTasks() {
//		return tasks;
//	}
//
//
//	public void setTasks(List<Task> tasks) {
//		this.tasks = tasks;
//	}
	
	
	

}
