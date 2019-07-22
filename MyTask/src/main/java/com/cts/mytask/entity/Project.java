package com.cts.mytask.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name ="project")
public class Project {

	
	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer projectId;
	
	@Column(name = "project")
	private String project;
	
	@Column(name = "priority")
	private Integer priority;

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	
	
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	@JsonBackReference(value="project_user_reference")
	private User user;
	

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "project_task_reference")
	private List<Task> tasks;

	
	@Transient
	private Integer userId;
	
	
	@Transient
	private String actions;
	
	@Transient
	private String username;
	
	
	public Integer getProjectId() {
		return projectId;
	}


	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getActions() {
		return actions;
	}


	public void setActions(String actions) {
		this.actions = actions;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
}
