import { Component, OnInit } from '@angular/core';
import {User} from './../User';
import {TaskService} from  './../task.service';
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import {MatSort, MatTableDataSource} from '@angular/material';
import { ViewChild } from '@angular/core';
import { DataSource } from '@angular/cdk/table';
import * as $ from 'jquery';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {

  user:User = new User();
  displayedColumns: string[] = ['userId','firstName','lastName','employeeId','actions'];
  
  
  dataSource;


  constructor(private taskService: TaskService,private router:Router) { }
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {
    //alert("inside List user");
    this.taskService.getUserList().subscribe(
      list=>{
        
       this.dataSource = new MatTableDataSource(list);
        this.dataSource.sort= this.sort;
      });
  }
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  deleteUser(user:User){
    
    if(confirm("Are you sure to Remove "+user.firstName)) {
      this.taskService.deleteUser(user.userId).subscribe(
         data=>{
          
          if(data == "DELETE"){
            alert(user.firstName+" Removed");
          }
          console.log(data);
        },
        error => {
          console.log(error);
        },
        () => {
          this.router.navigate(['/listUser']);
        

        }
      );
    }


        
  }
  editUser(user:User): void{
  
  localStorage.removeItem("editUserId");
  localStorage.setItem("editUserId",user.userId.toString());
 
  this.router.navigate(['editUser']);
  }

}
