// import { Injectable } from '@angular/core';
// import { BehaviorSubject, Observable } from 'rxjs';
// import { map } from 'rxjs/operators';
// import { User } from '../models/user.model';
// import { Login } from '../models/login.model';
// import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { jwtDecode } from 'jwt-decode';
 
 
 
// @Injectable({
//   providedIn: 'root'
// })
// export class AuthService {
 
//   private readonly apiUrl = 'https://8080-faafeaecbeeabaaccfbbfcbfefde.premiumproject.examly.io';
//   private tokenKey = 'authToken';
//   public  userRoleSubject = new BehaviorSubject<string | null>(null);
//   private usernameSubject = new BehaviorSubject<string | null>(null);
//   private userIdSubject = new BehaviorSubject<number | null>(null);
 
//   // private jwtHelper: JwtHelperService;
 
//   constructor(private http: HttpClient) {
//     // this.initializeAuthState();
//   }
//   register(user: User): Observable<any> {
//     return this.http.post(`${this.apiUrl}/api/register`, user, { headers: null });
//   }
 
//   public initializeAuthState(): void {
//     const token = this.getAuthToken();
//     console.log("Token"+token)
   
 
//     if (token) {
//       try {
//         const decoded: any = jwtDecode(token);
//         if (decoded && decoded.userId) {
//           this.userIdSubject.next(decoded.userId);
//           this.userRoleSubject.next(decoded.userRole);
//           this.usernameSubject.next(decoded.username);
//         }
//       } catch (error) {
//         console.error('Invalid token specified: must be a valid JWT', error);
//         this.logout();
//       }
//     } else {
//       console.error('Invalid token specified: must be a string');
//       this.logout();
//     }
//   }
 
//   logout(): void {
//     this.userRoleSubject.next(null);
//     this.usernameSubject.next(null);
//     this.userIdSubject.next(null);
//     localStorage.removeItem('authToken');
//     localStorage.removeItem('LoginDTOObj');
 
//     // Redirect or show an error message if needed
//     // this.router.navigate(['/login']); // Uncomment this line if you want to redirect to the login page
//   }
 
//   private decodeToken(token: string): any {
//     const decoded: any = jwtDecode(token);
//     console.log(decoded);
   
//     if (decoded) {
//       this.userRoleSubject.next(decoded.role);
//       this.usernameSubject.next(decoded.sub);  // Assuming "sub" is used as the username in your token
//       if (decoded.userId) {
//         this.userIdSubject.next(decoded.userId);
//       }
//       return decoded;
//     }
//     return null;
//   }
 
 
//   login(login: Login): Observable<any> {
//     return this.http.post<{ token: string, email: string, userRole: string, userId: number }>(`${this.apiUrl}/api/login`, login)
//       .pipe(map(response => {
//         localStorage.setItem('LoginDTOObj', JSON.stringify(response));
//         this.setAuthToken(response.token);
//         this.updateUserDetails(response);
//         this.initializeAuthState();
//         return response;
//       }));
//   }
 
//   private setAuthToken(token: string): void {
//     localStorage.setItem(this.tokenKey, token);
//     this.decodeToken(token);
//   }
 
//   private updateUserDetails(response: { token: string, email: string, userRole: string, userId: number }): void {
//     this.userRoleSubject.next(response.userRole);
//     this.userIdSubject.next(response.userId);
//     this.usernameSubject.next(response.email);
//   }
 
 
 
//   getAuthToken(): string | null {
//     return localStorage.getItem(this.tokenKey);
//   }
 
//   getAuthHeaders(): HttpHeaders {
 
//     const token = this.getAuthToken();
//     return new HttpHeaders({
//       'Authorization': `Bearer ${token}`
//     });
//   }
 
//   get userRole$(): Observable<string | null> {
//     return this.userRoleSubject.asObservable();
//   }
 
//   get username$(): Observable<string | null> {
//     return this.usernameSubject.asObservable();
//   }
 
//   get userId$(): Observable<number | null> {
//     return this.userIdSubject.asObservable();
//   }
 
//   isLoggedIn(): boolean {
//     return !!this.getAuthToken();
//   }
 
//   isManager(): boolean {
//     let role = this.decodeToken(localStorage.getItem('authToken'))?.role;
//     return role === 'MANAGER';
//   }
 
//   isClient(): boolean {
//     let role = this.decodeToken(localStorage.getItem('authToken'))?.role;
//     return role === 'CLIENT';
//   }
// }
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../models/user.model';
import { Login } from '../models/login.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { jwtDecode } from 'jwt-decode';
 
@Injectable({
  providedIn: 'root'
})
export class AuthService {
 
  private readonly apiUrl = 'https://8080-aacbefabacaaeabaaccfbbfcbfefde.premiumproject.examly.io';
  private tokenKey = 'authToken';
  public userRoleSubject = new BehaviorSubject<string | null>(null);
  private usernameSubject = new BehaviorSubject<string | null>(null);
  private userIdSubject = new BehaviorSubject<number | null>(null);
 
  constructor(private http: HttpClient) {
    this.initializeAuthState();
  }
 
  register(user: User): Observable<any> {
    return this.http.post(`${this.apiUrl}/api/register`, user, { headers: null });
  }
 
  public initializeAuthState(): void {
    const token = this.getAuthToken();
    if (token) {
      this.decodeToken(token);
    }
  }
 
  logout(): void {
    this.userRoleSubject.next(null);
    this.usernameSubject.next(null);
    this.userIdSubject.next(null);
    localStorage.removeItem(this.tokenKey);
    localStorage.removeItem('LoginDTOObj');
  }
 
  private decodeToken(token: string): void {
    try {
      const decoded: any = jwtDecode(token);
      if (decoded) {
        this.userRoleSubject.next(decoded.role);
        this.usernameSubject.next(decoded.sub);
        this.userIdSubject.next(decoded.userId);
      }
    } catch (error) {
      console.error('Invalid token', error);
      this.logout();
    }
  }
 
  login(login: Login): Observable<any> {
    return this.http.post<{ token: string, email: string, userRole: string, userId: number }>(`${this.apiUrl}/api/login`, login)
      .pipe(map(response => {
        localStorage.setItem(this.tokenKey, response.token);
        localStorage.setItem('LoginDTOObj', JSON.stringify(response));
        this.decodeToken(response.token);
        return response;
      }));
  }
 
  getAuthToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }
 
  getAuthHeaders(): HttpHeaders {
    const token = this.getAuthToken();
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
  }
 
  get userRole$(): Observable<string | null> {
    return this.userRoleSubject.asObservable();
  }
 
  get username$(): Observable<string | null> {
    return this.usernameSubject.asObservable();
  }
 
  get userId$(): Observable<number | null> {
    return this.userIdSubject.asObservable();
  }
 
  isLoggedIn(): boolean {
    return !!this.getAuthToken();
  }
 
  isManager(): boolean {
    return this.userRoleSubject.value === 'MANAGER';
  }
 
  isClient(): boolean {
    return this.userRoleSubject.value === 'CLIENT';
  }
}
 