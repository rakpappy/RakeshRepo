import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import {User} from "./../User";
import {TaskService} from "./../task.service";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  user:User;
  editUserForm:FormGroup;

  constructor(private taskService:TaskService,private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit() {
    this.editUserForm = this.formBuilder.group({
      userId: [],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      employeeId: ['', Validators.required],
      actions:[]
     
    });
    let userId = localStorage.getItem("editUserId");
    
    
        //alert("Inside edit page"+taskId);
        this.taskService.getUser(+userId)
        .subscribe( data => {
          this.editUserForm.setValue(data);
        });
  }
  onSubmit() {
    alert(this.editUserForm.value.userId);
    this.taskService.createUser(this.editUserForm.value).
    pipe(first())
    .subscribe(
      data => {
        this.router.navigate(['/listUser']);
      },
      error => {
        alert(error);
      });
   }
}
