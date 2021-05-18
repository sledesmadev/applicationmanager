import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Application } from '../model/application';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {
  private apiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }


  public getApplications(): Observable<Application[]>{
    return this.http.get<Application[]>(this.apiUrl+'/application/getAll')
  }

  public addApplication(application: Application): Observable<Application>{
    return this.http.post<Application>(this.apiUrl+'/application/newApp', application)
  }

  public updateApplication(application: Application): Observable<Application>{
    return this.http.put<Application>(this.apiUrl+'/application/update', application)
  }

  public deleteApplication(applicationId:number): Observable<void>{
    return this.http.delete<void>(this.apiUrl+'/application/delete/'+applicationId)
  }


}
