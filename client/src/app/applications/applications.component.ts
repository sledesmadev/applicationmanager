import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { Application } from '../model/application';
import { User } from '../model/user';
import { ApplicationService } from '../services/application-service.service';

@Component({
  selector: 'app-applications',
  templateUrl: './applications.component.html',
  styleUrls: ['./applications.component.css']
})
export class ApplicationsComponent implements OnInit{
  public applications: Application[];

  constructor(private applicationService: ApplicationService) { }

  ngOnInit(): void {
    this.getApplications();
  }

  public getApplications(): void{
    this.applicationService.getApplications().subscribe(
      (response: Application[]) =>{
        this.applications = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      } 
    )
  }

  public getAdmins(users:User[]): string{
      if(users.length === 1){
        return users[0].username;
      }else if(users.length > 1){
        let out = [];
        users.forEach(function(values){
          out.push(values.username);
        })
        return out.join(', ')
      }else{
        return ''
      }
  }

  public getDateFormat(date: Date): string{
    if(date){
      return moment(date).format('YYYY-MM-DD HH:mm:ss');
    }
  }

  public searchApplication(key:string): void{
     const result: Application[] = [];
     for(const application of this.applications){
       if(application.name.toLowerCase().indexOf(key.toLowerCase()) !== -1 ){
            result.push(application);
       }
     }
     this.applications = result;
     if(!key){
       this.getApplications();
     }      
  }
}
