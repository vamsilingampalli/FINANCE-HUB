import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isClient:boolean=this.authService.isClient()
  isManager:boolean=this.authService.isManager()
  isLoggedIn:boolean=this.authService.isLoggedIn();

  constructor(private authService:AuthService) { }
  
  ngOnInit(): void {
    this.isLoggedIn=this.authService.isLoggedIn()
    this.isClient=this.authService.isClient()
    this.isManager=this.authService.isManager()
    console.log("isClient"+this.isClient+" : "+"Manager"+this.isManager+" isLoggedIn:"+this.isLoggedIn);
  }
}
