package com.cts.mytask.dao;

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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.mytask.entity.ParentTask;
import com.cts.mytask.entity.Project;
import com.cts.mytask.entity.Task;
import com.cts.mytask.entity.User;

@Repository
public class TaskManagerDaoImpl implements TaskManagerDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("User Id =" + user.getEmployeeId());
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		
		
		if (null != user.getUserId()) {
			System.out.println("update" + user.getUserId());
			session.update(user);
		} else {
			System.out.println("save" + user.getUserId());
			session.save(user);
		}

		tx.commit();
	
		session.close();

		return "SUCCESS";
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		List<Project> projectList = new ArrayList();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);
		criteriaQuery.from(User.class);

		List<User> users = session.createQuery(criteriaQuery).getResultList();

		
		tx.commit();
		session.close();
		return users;
	}

	@Override
	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		String deleteUser = "delete from user where user_id =" + userId;

		Query query = session.createSQLQuery(deleteUser);

		int x = query.executeUpdate();

		// Delete a persistent object

		tx.commit();
		session.close();
		return "DELETE";
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		// Delete a persistent object
		User user = session.get(User.class, userId);

		System.out.println("USER ID " + user.getUserId());

		tx.commit();
		session.close();
		return user;
	}

	@Override
	public String addProject(Project project) {
		// TODO Auto-generated method stub
		System.out.println("User Id =" + project.getUserId());

		List<Project> projectList = new ArrayList<Project>();

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		User user = session.get(User.class, project.getUserId());

		project.setUser(user);

		projectList.add(project);

		user.setProjects(projectList);

		session.update(user);
		tx.commit();
		session.close();

		return "SUCCESS";
	}

	@Override
	public List<Project> getProjectList() {
		// TODO Auto-generated method stub
		List<Project> projectList = new ArrayList();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);
		criteriaQuery.from(User.class);

		List<User> users = session.createQuery(criteriaQuery).getResultList();

		if (null != users) {

			for (int i = 0; i < users.size(); i++) {

				if (null != users.get(i).getProjects()) {

					for (int j = 0; j < users.get(i).getProjects().size(); j++) {
						Project p = new Project();
						p.setProjectId(users.get(i).getProjects().get(j).getProjectId());
						p.setProject(users.get(i).getProjects().get(j).getProject());
						p.setPriority(users.get(i).getProjects().get(j).getPriority());
						p.setStartDate(users.get(i).getProjects().get(j).getStartDate());
						p.setEndDate(users.get(i).getProjects().get(j).getEndDate());
						p.setUsername(users.get(i).getFirstName());
						p.setUserId(users.get(i).getUserId());

						projectList.add(p);
					}
				}
			}

		}

		tx.commit();
		session.close();
		return projectList;
	}

	@Override
	public Project getProjec(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		Project project = new Project();

		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(User.class);
		cr.createAlias("projects", "p");
		cr.add(Restrictions.eq("p.id", id));

		User u = (User) cr.uniqueResult();

		project.setUserId(u.getUserId());
		project.setUsername(u.getFirstName());

		if (null != u.getProjects()) {
			for (int i = 0; i < u.getProjects().size(); i++) {
				project.setProject(u.getProjects().get(i).getProject());
				project.setProjectId(u.getProjects().get(i).getProjectId());
				project.setPriority(u.getProjects().get(i).getPriority());
				project.setStartDate(u.getProjects().get(i).getStartDate());
				project.setEndDate(u.getProjects().get(i).getEndDate());

			}

		}

		tx.commit();
		session.close();
		return project;
	}

	@Override
	public String deleteProject(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		String deleteProject = "delete from project where project_id =" + id;

		Query query = session.createSQLQuery(deleteProject);

		int x = query.executeUpdate();

		tx.commit();
		session.close();
		return "deleted";
	}

	@Override
	public String updateProject(Project project) {
		// TODO Auto-generated method stub
		System.out.println("User Id................. =" + project.getUserId());
		System.out.println("project Id................. =" + project.getProjectId());
		System.out.println("start date................. =" + project.getStartDate());
		System.out.println("end date................. =" + project.getEndDate());
		System.out.println("priority................. =" + project.getPriority());
		System.out.println("project name................. =" + project.getProject());

		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your
		// template here
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
		 * Locale.ENGLISH); java.util.Date dateStr =
		 * sdf.parse(project.getStartDate().toString()); java.sql.Date dateDB = new
		 * java.sql.Date(dateStr.getTime());
		 */

		List<Project> projectList = new ArrayList<Project>();

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		User user = session.get(User.class, project.getUserId());

		project.setUser(user);

		projectList.add(project);

		user.setProjects(projectList);

		session.update(user);
		tx.commit();
		session.close();

		// return "SUCCESS";

		return "UPDATE";

	}

	@Override
	public String addTask(Task task) {
		// TODO Auto-generated method stub
		System.out.println("User Id................. =" + task.getUserId());
		System.out.println("project Id................. =" + task.getProjectId());
		System.out.println(" Parent Task Id................. =" + task.getParentId());

		List<Task> taskListUser = new ArrayList<>();
		List<Task> taskList = new ArrayList<>();
		List<Task> parentTaskList = new ArrayList<>();

		ParentTask pt = new ParentTask();

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		User user = session.get(User.class, task.getUserId());
		Project project = session.get(Project.class, task.getProjectId());
		task.setUsername(user.getFirstName());
		task.setUserTask(user);

		taskListUser.add(task);

		task.setProjectName(project.getProject());
		task.setProject(project);

		if (null != task.getParentId()) {
			ParentTask parentTask = session.get(ParentTask.class, task.getParentId());
			task.setParentTask(task.getParentTask());
			parentTaskList.add(task);
			parentTask.setTasks(parentTaskList);
			session.save(parentTask);
		} else {
			task.setParentTask(task.getTask());
			pt.setParentTask(task.getParentTask());
			parentTaskList.add(task);
			pt.setTasks(parentTaskList);
			session.save(pt);
		}

		taskList.add(task);

		user.setTasks(taskListUser);
		project.setTasks(taskList);
		session.update(user);
		session.update(project);

		tx.commit();
		session.close();

		return "SUCCESS";
	}

	@Override
	public List<Task> getTaskList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		CriteriaQuery<Task> criteriaQuery = session.getCriteriaBuilder().createQuery(Task.class);
		criteriaQuery.from(Task.class);

		List<Task> taskList = session.createQuery(criteriaQuery).getResultList();

		tx.commit();
		session.close();
		return taskList;
	}

	@Override
	public Task getask(int taskId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		Task t = new Task();

		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Task.class);
		Task task = session.get(Task.class,taskId);
		
		Criteria cr1 = session.createCriteria(User.class);
		cr1.createAlias("tasks", "t");
		cr1.add(Restrictions.eq("t.id", taskId));

		User u = (User) cr1.uniqueResult();
		task.setUserId(u.getUserId());
		
		Criteria cr2 = session.createCriteria(Project.class);
		cr2.createAlias("tasks", "t");
		cr2.add(Restrictions.eq("t.id", taskId));

		Project p = (Project) cr2.uniqueResult();
		task.setProjectId(p.getProjectId());
		
		
		Criteria cr3 = session.createCriteria(ParentTask.class);
		cr3.createAlias("tasks", "t");
		cr3.add(Restrictions.eq("t.id", taskId));

		ParentTask pt = (ParentTask) cr3.uniqueResult();
		task.setParentId(pt.getParentId());
		
		tx.commit();
		session.close();
		return task;
	}

	@Override
	public String deleteTask(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		String deleteTask = "delete from task where task_id =" + id;

		Query query = session.createSQLQuery(deleteTask);

		int x = query.executeUpdate();

		tx.commit();
		session.close();
		return "deleted";
	}

	@Override
	public List<ParentTask> getParentTaskList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		CriteriaQuery<ParentTask> criteriaQuery = session.getCriteriaBuilder().createQuery(ParentTask.class);
		criteriaQuery.from(ParentTask.class);

		List<ParentTask> parentTaskLIst = session.createQuery(criteriaQuery).getResultList();
		return parentTaskLIst;
	}

	

}
