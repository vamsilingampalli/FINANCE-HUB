// import { Component, OnInit } from '@angular/core';
// import { Router } from '@angular/router';
// import { AuthService } from 'src/app/services/auth.service';

// @Component({
//   selector: 'app-usernav',
//   templateUrl: './usernav.component.html',
//   styleUrls: ['./usernav.component.css']
// })
// export class UsernavComponent implements OnInit {
//   currentDTOobj=localStorage.getItem('LoginDTOObj');
//   username:string='';
//   constructor(private router:Router,private authService:AuthService) { }
//   showDropdown = false;
//   ngOnInit(): void {
//     console.log(JSON.parse(this.currentDTOobj).username);
//     this.username=JSON.parse(this.currentDTOobj).username;
//     console.log("Current:"+this.username);
//   }
  


//   toggleDropdown() {
//     const dropdown = document.getElementById('feedbacks');
//     dropdown.classList.toggle('show');
//   }
//   logout() {
  
//     this.authService.logout()
//     this.router.navigate(['/login'])
//   }

// }
import { Component, OnInit, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-usernav',
  templateUrl: './usernav.component.html',
  styleUrls: ['./usernav.component.css']
})
export class UsernavComponent implements OnInit {
  currentDTOobj = localStorage.getItem('LoginDTOObj');
  username: string = '';
  showDropdown: boolean = false;

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
    this.username = JSON.parse(this.currentDTOobj).username;
  }

  toggleDropdown() {
    this.showDropdown = !this.showDropdown;
  }

  @HostListener('document:click', ['$event'])
  onClickOutside(event: Event) {
    const dropdown = document.getElementById('dropdown-menu');
    if (dropdown && !dropdown.contains(event.target as Node)) {
      this.showDropdown = false;
    }
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}