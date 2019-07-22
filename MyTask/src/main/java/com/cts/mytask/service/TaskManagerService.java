
package com.cts.mytask.service;

import java.util.List;

import com.cts.mytask.entity.ParentTask;
import com.cts.mytask.entity.Project;
import com.cts.mytask.entity.Task;
import com.cts.mytask.entity.User;

public interface TaskManagerService {
	
	public String hello();
	public String addUser(User user);
	 public List<User> getUserList();
	 public String deleteUser(int userId);
	 public User getUser (int userId);
	 public String addProject(Project project);
	 public List<Project> getProjectList();
	 public Project getProjec(int id);
	 public String deleteProject(int id);
	 public String updateProject(Project project);
	 public String addTask(Task task);
	 public List<Task> getTaskList();
	 public Task getask(int id);
	 public String deleteTask(int id);
	 public List<ParentTask> getParentTaskList();
}
