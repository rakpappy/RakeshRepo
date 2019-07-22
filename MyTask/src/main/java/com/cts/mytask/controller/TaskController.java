package com.cts.mytask.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mytask.entity.ParentTask;
import com.cts.mytask.entity.Project;
import com.cts.mytask.entity.Task;
import com.cts.mytask.entity.User;
import com.cts.mytask.service.TaskManagerService;
//import com.cts.mytask.service.TaskManagerService;

@RestController
@CrossOrigin("http://localhost:4200")
public class TaskController {

	
	 @Autowired 
	 TaskManagerService taskManagerService;
	 
	@Autowired
	SessionFactory sessionFactory;

	@GetMapping("/")
	public String hello() {

		return "welcome";
	}

	

	@PostMapping(value = "/addUser")
	public String addUser(@RequestBody User user) {

		return taskManagerService.addUser(user);
	}

	/*
	 * Getting User List
	 */
	@GetMapping("/userList")
	public List<User> getListUser() {

		return taskManagerService.getUserList();
	}

	/*
	 * Delete userId
	 * 
	 */
	@DeleteMapping("deleteUser/{userId}")
	public String deleteUser(@PathVariable(value = "userId") int userId) {

		return taskManagerService.deleteUser(userId);
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable(value = "id") int id) {

		return taskManagerService.getUser(id);
	}

	@PostMapping(value = "/addProject")
	public String addProject(@RequestBody Project project) {

		return taskManagerService.addProject(project);
	}

	@GetMapping("/projectList")
	public List<Project> getProjectList() {

		return taskManagerService.getProjectList();
	}

	@GetMapping("/project/{id}")
	public Project getProject(@PathVariable(value = "id") int id) {

		return taskManagerService.getProjec(id);
	}

	@DeleteMapping("deleteProject/{projectId}")
	public String deleteProject(@PathVariable(value = "projectId") int projectId) {

		return taskManagerService.deleteProject(projectId);
	}

	@PostMapping(value = "/updateProject")
	public String updateProject(@RequestBody Project project) throws ParseException {

		return taskManagerService.updateProject(project);
	}

	@GetMapping("/parentTaskList")
	public List<ParentTask> getParentTaskList() {

		return taskManagerService.getParentTaskList();
	}

	@PostMapping(value = "/addTask")
	public String addTask(@RequestBody Task task) {
		return taskManagerService.addTask(task);
	}

	@GetMapping("/taskList")
	public List<Task> getTaskList() {

		return taskManagerService.getTaskList();
	}

	@DeleteMapping("deleteTask/taskId}")
	public String deleteTask(@PathVariable(value = "taskId") int taskId) {

		return taskManagerService.deleteTask(taskId);
	}

	@GetMapping("/task/{taskId}")
	public Task getask(@PathVariable(value = "taskId") int taskId) {
		return taskManagerService.getask(taskId);
		
	}

}
