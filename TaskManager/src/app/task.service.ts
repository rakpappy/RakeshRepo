import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from "./Task";
import { User } from "./User";
import { Project } from "./Project";
@Injectable({

  providedIn: 'root'
})
export class TaskService {

  private baseUrl = 'http://localhost:8085';

  constructor(private http: HttpClient) { }

  myText: String;

  createTask(task: Object): Observable<Object> {

    return this.http.post(`${this.baseUrl}/addTask`, task, { responseType: 'text' });

  }


  getTaskList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/taskList`);
  }
  getParentTaskList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/parentTaskList`);
  }
  deleteTask(taskId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteTask/` + taskId, { responseType: 'text' });
  }
  getTask(taskId: number) {
    return this.http.get<Task>(`${this.baseUrl}/task/` + taskId)
  }

  createUser(user: Object): Observable<Object> {

    return this.http.post(`${this.baseUrl}/addUser`, user, { responseType: 'text' });

  }
  getUserList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/userList`);
  }
  deleteUser(userId: number): Observable<any> {
    
    return this.http.delete(`${this.baseUrl}/deleteUser/` + userId, { responseType: 'text' });
  }
  getUser(id: number) {
    return this.http.get<User>(`${this.baseUrl}/user/` + id)
  }
  createProject(project: Object): Observable<Object> {

    return this.http.post(`${this.baseUrl}/addProject`, project, { responseType: 'text' });

  }
  getProjectList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/projectList`);
  }
  deleteProject(projectId: number): Observable<any> {
    
    return this.http.delete(`${this.baseUrl}/deleteProject/` + projectId, { responseType: 'text' });
  }
  getProject(id: number) {
    return this.http.get<Project>(`${this.baseUrl}/project/` + id)
  }
  getProjectEdit(id: number) {
    return this.http.get<Project>(`${this.baseUrl}/projectEdit/` + id)
  }
  updateProject(project: Object): Observable<Object> {
    
        return this.http.post(`${this.baseUrl}/updateProject`, project, { responseType: 'text' });
    
  }
  
}
