import { Component, OnInit } from '@angular/core';
import {  NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
 
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
 
  registrationSuccess:boolean=false;
  errorMessage:string=''
  constructor(private authService:AuthService,private router:Router) { }

  register(form:NgForm):void {
    if(form.valid){
      let userDetails:User={
        email: form.value.email,
        password: form.value.password,
        username: form.value.username,
        mobileNumber: form.value.mobileNumber,
        userRole: form.value.userRole
      };
      console.log("asdfghjkl");
      
      this.authService.register(userDetails).subscribe(()=>{
        this.registrationSuccess=true;
      },
      (error)=>{
        this.errorMessage=error.error;
      })
    }
  }
 
  redirectToLogin(){
    this.router.navigate(['/login'])
  }
}