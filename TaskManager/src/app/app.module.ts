import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSliderModule} from '@angular/material/slider';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTaskComponent } from './add-task/add-task.component';
import { ListTaskComponent } from './list-task/list-task.component';
import { FormsModule } from '@angular/forms';
import 'hammerjs';
import {ReactiveFormsModule} from "@angular/forms";
import { MatDatepickerModule, MatInputModule, MatNativeDateModule } from '@angular/material'
import { GrdFilterPipe } from './grd-filter.pipe';
import { EditTaskComponent } from './edit-task/edit-task.component';
import { ProjectComponent } from './project/project.component';
import { UserComponent } from './user/user.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import {MatTableModule} from '@angular/material';
import  {MatSortModule,MatIconModule} from '@angular/material';
import {MatSelectModule} from '@angular/material/select';
import { EditUserComponent } from './edit-user/edit-user.component';
import { ListUserComponent } from './list-user/list-user.component';
import { ListProjectComponent } from './list-project/list-project.component';
import { EditProjectComponent } from './edit-project/edit-project.component';


@NgModule({
  declarations: [
    AppComponent,
    AddTaskComponent,
    ListTaskComponent,
    GrdFilterPipe,
    EditTaskComponent,
    ProjectComponent,
    UserComponent,
    EditUserComponent,
    ListUserComponent,
    ListProjectComponent,
    EditProjectComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatDatepickerModule,
    MatInputModule,
    MatNativeDateModule,
    BrowserAnimationsModule,
    MatSliderModule,
    ReactiveFormsModule,
    MatTableModule,
    MatSortModule,
    MatIconModule,
    MatSelectModule
   // GrdFilterPipe
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
