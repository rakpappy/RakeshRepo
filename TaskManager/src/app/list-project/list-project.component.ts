import { Component, OnInit } from '@angular/core';
import {Project} from './../Project';
import {TaskService} from  './../task.service';
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import {MatSort, MatTableDataSource} from '@angular/material';
import { ViewChild } from '@angular/core';
import { DataSource } from '@angular/cdk/table';

@Component({
  selector: 'app-list-project',
  templateUrl: './list-project.component.html',
  styleUrls: ['./list-project.component.css']
})
export class ListProjectComponent implements OnInit {

  project:Project = new Project();
  
  displayedColumns: string[] = ['projectId','project','priority','username','startDate','endDate','actions'];
  
  
  dataSource;


  constructor(private taskService: TaskService,private router:Router) { }
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {

    this.taskService.getProjectList().subscribe(
      list=>{
        
       this.dataSource = new MatTableDataSource(list);
        this.dataSource.sort= this.sort;
      });
  }
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  deleteProject(project:Project){
       
      if(confirm("Are you sure to Remove "+project.project)) {
        this.taskService.deleteProject(project.projectId).subscribe(
           data=>{
            
            if(data == "DELETE"){
              alert(project.project+" Removed");
            }
            console.log(data);
          },
          error => {
            console.log(error);
          },
          () => {
            this.router.navigate(['/listProject']);
          
  
          }
        );
      }


  }
  editProject(project:Project): void{

    localStorage.removeItem("editProjectId");
    localStorage.setItem("editProjectId",project.projectId.toString());
   
    this.router.navigate(['editProject']);
    }

}
