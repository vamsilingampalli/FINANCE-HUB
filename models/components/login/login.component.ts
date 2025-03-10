
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/models/login.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string = '';
  password: string = '';

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void { }

  login(): void {
    const loginData: Login = { email: this.email, password: this.password }; // Prepare login data
    console.log('Login data:', loginData); // Log the login data for debugging
    this.authService.login(loginData).subscribe(
      response => {
        console.log('Login successful:', response);
        alert('Login successful!');
        this.authService.initializeAuthState();
        this.router.navigate(['']); // Navigate to the desired route after login
      },
      error => {
        console.error('Login failed:', error);
        alert('Login failed! Please check your credentials.');
      }
    );
  }
}
