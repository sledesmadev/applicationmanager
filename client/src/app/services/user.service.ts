import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from 'src/environments/environment';
import { User } from '../model/user';
import { UserDTO } from '../model/userDTO';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public login(user: UserDTO): Observable<User>{
    return this.http.post<User>(this.apiUrl+'/auth/login', user)
  }

  public signup(user: UserDTO): Observable<User>{
    return this.http.post<User>(this.apiUrl+'/auth/signup', user)
  }

}
