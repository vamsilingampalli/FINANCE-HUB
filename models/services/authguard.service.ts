import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, Router, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';  // Adjust the import path if needed
 
@Injectable({
  providedIn: 'root'
})
export class AuthguardService implements CanActivate {
  constructor(
    private router: Router,
    private authService: AuthService  // Use AuthService instead of UserStoreService
  ) {}
 
  canActivate(route: ActivatedRouteSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/login']);
      return false;
    }
 
    const requiredRole = route.data['role'];
    if (requiredRole) {
      const userRole = this.authService.userRoleSubject.value;
      if (requiredRole === 'MANAGER' && userRole !== 'MANAGER') {
        this.router.navigate(['/error']);
        return false;
      }
      if (requiredRole === 'CLIENT' && userRole !== 'CLIENT') {
        this.router.navigate(['/error']);
        return false;
      }
    }
 
    return true;
  }
}