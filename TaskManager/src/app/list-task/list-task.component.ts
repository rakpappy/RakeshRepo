import { Component, OnInit } from '@angular/core';

import { Task } from "./../Task";
import {Project} from './../Project';
import {TaskService} from  './../task.service';
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import {MatSort, MatTableDataSource} from '@angular/material';
import { ViewChild } from '@angular/core';
import { DataSource } from '@angular/cdk/table';


@Component({
  selector: 'app-list-task',
  templateUrl: './list-task.component.html',
  styleUrls: ['./list-task.component.css']
})
export class ListTaskComponent implements OnInit {

  public searchTask : string;
  public searchParentTask:string;
  

  displayedColumns: string[] = ['taskId','task','projectName','parentTask','priority','username','startDate','endDate','actions'];
  
  
  dataSource;

  tasks: Observable<Task[]>;

  constructor(private taskService: TaskService,private router :Router)
 { }
 @ViewChild(MatSort) sort: MatSort;
  ngOnInit() {
    this.taskService.getTaskList().subscribe(
      list=>{
        
       this.dataSource = new MatTableDataSource(list);
        this.dataSource.sort= this.sort;
      });
  }

  reloadData() {
    this.tasks = this.taskService.getTaskList();
  }
  
  deleteTask(task:Task){
  
    if(confirm("Are you sure to Remove "+task.task)) {
      this.taskService.deleteTask(task.id).subscribe(
         data=>{
          
          if(data == "DELETE"){
            alert(task.task+" Removed");
          }
          console.log(data);
        },
        error => {
          console.log(error);
        },
        () => {
          this.router.navigate(['/list']);
        

        }
      );
  
  }
}
  editTask(task:Task){
    //alert(task.id);
    alert(task.task);
    localStorage.removeItem("editTaskId");
    localStorage.setItem("editTaskId",task.id.toString());
    this.router.navigate(['edit']);
  }

}
