import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddTaskComponent} from './add-task/add-task.component';
import {ListTaskComponent} from './list-task/list-task.component';
import {EditTaskComponent} from './edit-task/edit-task.component';
import {ProjectComponent} from './project/project.component';
import {UserComponent} from './user/user.component';
import {EditUserComponent} from './edit-user/edit-user.component';
import {ListUserComponent} from './list-user/list-user.component';
import {ListProjectComponent} from './list-project/list-project.component';
import {EditProjectComponent} from './edit-project/edit-project.component';


const routes: Routes = [

  { path: 'add', component: AddTaskComponent },
  { path: 'list', component: ListTaskComponent },
  { path: 'edit', component: EditTaskComponent },
  { path: 'project', component: ProjectComponent },
  { path: 'user', component: UserComponent} ,
  { path: 'editUser', component: EditUserComponent},
  { path: 'listUser', component: ListUserComponent},
  { path: 'listProject', component: ListProjectComponent},
  { path: 'editProject', component: EditProjectComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
