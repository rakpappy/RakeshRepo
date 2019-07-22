import { Component, OnInit } from '@angular/core';
import {Task} from './../Task';
import {TaskService} from  './../task.service';
import { Router } from "@angular/router";
import { Project } from './../Project';
import { User } from './../User';
import { ParentTask } from './../parentTask';
import { Observable } from "rxjs";
import * as $ from 'jquery';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  task: Task = new Task();
  submitted = false;
  projectsDrop : Project[];
  usersDrop: User[];
  parentTaskDrop:ParentTask[];

  constructor(private taskService: TaskService,private router:Router) { }

  ngOnInit() {
    this.taskService.getUserList().subscribe(
      list => {
        
        this.usersDrop = list;
        
      });
      this.taskService.getProjectList().subscribe(
        list => {
          
          this.projectsDrop = list;
          
        });
        this.taskService.getParentTaskList().subscribe(
          list => {
            
            this.parentTaskDrop = list;
            
          });
  }

  newTask(): void {
    this.submitted = false;
    this.task = new Task();
  }

  save() {
    this.taskService.createTask(this.task)
      .subscribe(data => console.log(data), error => console.log(error));
    this.task = new Task();
  }

  onSubmit() {
   // this.submitted = false;
    this.save();
    alert("Task Added Successfuly...");
   this.router.navigate(['/list']);
  }
  listTask(){
    
    this.router.navigate(['/list']);
  }

}
