
package com.cts.mytask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.mytask.dao.TaskManagerDao;
import com.cts.mytask.entity.ParentTask;
import com.cts.mytask.entity.Project;
import com.cts.mytask.entity.Task;
import com.cts.mytask.entity.User;

@Service
public class TaskManagerServiceImpl implements TaskManagerService {

	@Autowired
	TaskManagerDao taskManagerDao;

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		return taskManagerDao.addUser(user);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return taskManagerDao.getUserList();
	}

	@Override
	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		return taskManagerDao.deleteUser(userId);
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return taskManagerDao.getUser(userId);
	}

	@Override
	public String addProject(Project project) {
		// TODO Auto-generated method stub
		return taskManagerDao.addProject(project);
	}

	@Override
	public List<Project> getProjectList() {
		// TODO Auto-generated method stub
		return taskManagerDao.getProjectList();
	}

	@Override
	public Project getProjec(int id) {
		// TODO Auto-generated method stub
		return taskManagerDao.getProjec(id);
	}

	@Override
	public String deleteProject(int id) {
		// TODO Auto-generated method stub
		return taskManagerDao.deleteProject(id);
	}

	@Override
	public String updateProject(Project project) {
		// TODO Auto-generated method stub
		return taskManagerDao.updateProject(project);
	}

	@Override
	public String addTask(Task task) {
		// TODO Auto-generated method stub
		return taskManagerDao.addTask(task);
	}

	@Override
	public List<Task> getTaskList() {
		// TODO Auto-generated method stub
		return taskManagerDao.getTaskList();
	}

	@Override
	public Task getask(int id) {
		// TODO Auto-generated method stub
		return taskManagerDao.getask(id);
	}

	@Override
	public String deleteTask(int id) {
		// TODO Auto-generated method stub
		return taskManagerDao.deleteTask(id);
	}

	@Override
	public List<ParentTask> getParentTaskList() {
		// TODO Auto-generated method stub
		return taskManagerDao.getParentTaskList();
	}

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "hai";
	}

	
}
