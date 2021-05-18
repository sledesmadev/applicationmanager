import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDTO } from '../model/userDTO';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  user: UserDTO;

  constructor(private userService: UserService, private router: Router ) { 
    this.user = new UserDTO('','');
  }

  ngOnInit() {
  }

  public onSubmit(){
    this.userService.login(this.user).subscribe(
      (response: UserDTO) =>{
        alert('User logged')
        this.user = response;
        localStorage.setItem('user', JSON.stringify(this.user));
        this.router.navigate(['/applications']);
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      } 
    )
  }

}
