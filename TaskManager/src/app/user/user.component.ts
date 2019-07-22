import { Component, OnInit } from '@angular/core';
import {User} from './../User';
import {TaskService} from  './../task.service';
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import {MatSort, MatTableDataSource} from '@angular/material';
import { ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DataSource } from '@angular/cdk/table';
import * as $ from 'jquery';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
user:User = new User();



  constructor(private taskService: TaskService,private router:Router) { }  
  
  ngOnInit() {    
   
  }
  

  save() {
    this.taskService.createUser(this.user)
      .subscribe(data =>
        {
          
          if(data == "SUCCESS"){
            alert("USER Created Succesfully");
          }
          console.log(data);
        },
        error => {

          console.log(error);
        },
        () => {
          this.user = new User();
          this.router.navigate(['/listUser']);
        }
      
      );
  }

  onSubmit() {
    
    let firstName= $("#firstName").val();
    let lastName= $("#lastName").val();
    let employeeId= $("#employeeId").val();

    if(!firstName.match(/^[a-zA-Z]+$/)){
      alert("Please Enter Valid Firstname");
      return false;
    }
    if(!lastName.match(/^[a-zA-Z]+$/)){
      alert("Please Enter Valid Lastname");
      return false;
    }

    if(!employeeId.match(/^\d*[0-9](|.\d*[0-9]|,\d*[0-9])?$/)){
      alert("Please Enter 3 Digit Employee Id");
      return false;
    }
    this.save();
    
  }
  listUser(){
    this.router.navigate(['/listUser']);
  }

}
