import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-adminnav',
  templateUrl: './adminnav.component.html',
  styleUrls: ['./adminnav.component.css']
})
export class AdminnavComponent implements OnInit {
  currentDTOobj=localStorage.getItem('LoginDTOObj');
  username:string='';

  showDropdown = false;
  constructor(private router:Router,private authService:AuthService) { }
  isLogged:boolean=this.authService.isLoggedIn();
  
  ngOnInit(): void {
    this.username=JSON.parse(this.currentDTOobj).username;
  }
  toggleDropdown() {
    const dropdown = document.getElementById('savingsplan');
    dropdown.classList.toggle('show');
  }
  logout() {
    this.authService.logout();
    console.log("about login :"+this.isLogged);
    this.router.navigate(['/login'])
  }
}
