import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Enquiry } from '../models/enquiry.model';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class EnquiryService {
  public baseUrl: string = "https://8080-aacbefabacaaeabaaccfbbfcbfefde.premiumproject.examly.io/api/enquiries"
  constructor(private http: HttpClient, private authService: AuthService) { }
  private getAuthHeaders(): HttpHeaders {
    const token = this.authService.getAuthToken();
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
  }
  addEnquiry(enquiry: Enquiry): Observable<Enquiry> {
    return this.http.post<Enquiry>(this.baseUrl, enquiry, { headers: this.getAuthHeaders() })
  }

  getUserEnquiries(userId: number): Observable<Enquiry[]> {
    return this.http.get<Enquiry[]>(`${this.baseUrl}/user/${userId}`, { headers: this.getAuthHeaders() })
  }

  getEnquiryById(enquiryId: number): Observable<Enquiry> {
    return this.http.get<Enquiry>(`${this.baseUrl}/${enquiryId}`, { headers: this.getAuthHeaders() })
  }

  getAllEnquiry(): Observable<Enquiry[]> {
    return this.http.get<Enquiry[]>(this.baseUrl)
  }

  updateEnquiry(enquiryId: number, enquiry: Enquiry): Observable<Enquiry> {
    return this.http.put<Enquiry>(`${this.baseUrl}/${enquiryId}`, enquiry, { headers: this.getAuthHeaders() })
  }

  deleteEnquiry(enquiryId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${enquiryId}`, { headers: this.getAuthHeaders() })
  }

}
