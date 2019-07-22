
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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

@Table(name = "parenttask")
public class ParentTask {

	@Id

	@Column(name = "parent_id")

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parentId;

	@Column(name = "parent_task")
	private String parentTask;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pTask", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "parent_task_reference")
	private List<Task> tasks;

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

}
