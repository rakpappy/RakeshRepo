import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import {Task} from "./../Task";
import {TaskService} from "./../task.service";
import { Project } from './../Project';
import { User } from './../User';
import { ParentTask } from './../parentTask';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit {
      txt:String;
  task:Task;
  editForm:FormGroup;
  projectsDrop : Project[];
  usersDrop: User[];
  parentTaskDrop:ParentTask[];

  constructor(private taskService:TaskService,private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit() {
    this.editForm = this.formBuilder.group({
      id: [],
      task: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      priority: ['', Validators.required],
      parentTask: ['', Validators.required],
      parentId:[],
      userId:[],
      username:[],
      projectId:[],
      actions:[],
      projectName:[]


    });
   // this.editForm.setValue

    let taskId = localStorage.getItem("editTaskId");


    //alert("Inside edit page"+taskId);
    this.taskService.getTask(+taskId)
    .subscribe( data => {
      this.editForm.setValue(data);
    });

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
  onSubmit() {
   
   this.taskService.createTask(this.editForm.value).
   pipe(first())
   .subscribe(
     data => {
       this.router.navigate(['/list']);
     },
     error => {
       alert(error);
     });
  }
}
