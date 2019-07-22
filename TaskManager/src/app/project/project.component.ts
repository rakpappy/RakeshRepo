import { Component, OnInit } from '@angular/core';
import { Project } from './../Project';
import { User } from './../User';
import { TaskService } from './../task.service';
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import * as $ from 'jquery';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {



  

  project: Project = new Project();
  marked = false;
  dataSource;
  users: Observable<User[]>;
  usersDrop: User[];
  constructor(private taskService: TaskService, private router: Router) { }

  ngOnInit() {
    this.taskService.getUserList().subscribe(
      list => {
        
        this.usersDrop = list;
        
      });
    
    this.reloadData();
  }

  newProject(): void {
    
    this.project = new Project();
  }

  save() {
    this.taskService.createProject(this.project)
      .subscribe(data => console.log(data), error => console.log(error));
    this.project = new Project();
  }

  reloadData() {
    this.users = this.taskService.getUserList();

  }
  toggleVisibility(e) {
    if (e.target.checked) {

      $("#startDate").prop('disabled', false);
      $("#endDate").prop('disabled', false);
    } else {

      $("#startDate").prop('disabled', true);
      $("#endDate").prop('disabled', true);
    }

  }


  onSubmit() {
    
this.save();
    alert("Project Added Successfuly...");
    this.router.navigate(['/listProject']);

  }
  listProject(){
    
    this.router.navigate(['/listProject']);
  }
}
