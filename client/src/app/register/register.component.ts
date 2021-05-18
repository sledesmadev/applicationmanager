import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserDTO } from '../model/userDTO';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: UserDTO;

  constructor(private userService: UserService,   private router: Router ) { 
    this.user = new UserDTO('','');
  }

  ngOnInit() {
  }

  public onSubmit(){
    this.userService.signup(this.user).subscribe(
      (response: UserDTO) =>{
        alert('User registered')
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
