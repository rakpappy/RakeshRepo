
package com.cts.mytask.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity

@Table(name = "task")
public class Task {

	@Id

	@Column(name = "task_id")

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "task")
	private String task;

	@Column(name = "parent")
	private String parentTask;

	@Transient
	//@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer parentId;

	@Column(name = "priority")
	private Integer priority;

	@Column(name = "start_date")

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "end_date")

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	@JsonBackReference(value = "parent_task_reference")
	private ParentTask pTask;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@JsonBackReference(value="user_task_reference")
	private User userTask;
//	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	@JsonBackReference(value="project_task_reference")
	private Project project;
	
	
	@Transient
	private Integer userId;
	
	@Transient
	private Integer projectId;
	
	
	
	
	@Column(name = "project")
	private String projectName;
	
	@Column(name = "user")
	private String username;
	
	@Transient
	private String actions;
	
	
	
	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public ParentTask getpTask() {
		return pTask;
	}

	public void setpTask(ParentTask pTask) {
		this.pTask = pTask;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public User getUserTask() {
		return userTask;
	}

	public void setUserTask(User userTask) {
		this.userTask = userTask;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
