import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authToken = this.authService.getAuthToken();
    const registrationUrl = 'https://8080-bcccbccdfefadbeabaaccfbbfcbfefde.premiumproject.examly.io/api/register'; 

    // if (req.url.includes(registrationUrl)) {
    //   // If the request is for registration, bypass the interceptor
    //   return next.handle(req);
    // }

    // Otherwise, attach the authorization token
    console.log(req.url.includes(registrationUrl));
    if (authToken) {

      const authReq = req.clone({
        headers: req.headers.set('Authorization', `Bearer ${authToken}`)
      });

      console.log(authReq.headers);
      console.log("Token Attached");

      return next.handle(authReq);
    }
    return next.handle(req);

  }
}
