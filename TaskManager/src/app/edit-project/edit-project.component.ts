import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import {Project} from "./../Project";
import {TaskService} from "./../task.service";
import { User } from './../User';

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.css']
})
export class EditProjectComponent implements OnInit {
  
  project:Project;
  editProjectForm:FormGroup;
  usersDrop: User[];
  constructor(private taskService:TaskService,private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit() {
    this.editProjectForm = this.formBuilder.group({
      projectId: [],
      project: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      username: ['', Validators.required],
      priority:['', Validators.required],
      userId:['', Validators.required],
      actions:[],
      tasks:[]
    });
    let projectId = localStorage.getItem("editProjectId");
    
    
        //alert("Inside edit page"+taskId);
        this.taskService.getProject(+projectId)
        .subscribe( data => {
          this.editProjectForm.setValue(data);
        });
        this.taskService.getUserList().subscribe(
          list => {
            
            this.usersDrop = list;
            
          });
  }
  onSubmit() {
   
    this.taskService.updateProject(this.editProjectForm.value).
    pipe(first())
    .subscribe(
      data => {
        this.router.navigate(['/listProject']);
      },
      error => {
        alert(error);
      });
   }

}
