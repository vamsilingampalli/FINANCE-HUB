import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Enquiry } from 'src/app/models/enquiry.model';
import { EnquiryService } from 'src/app/services/enquiry.service';

@Component({
  selector: 'app-userviewenquiry',
  templateUrl: './userviewenquiry.component.html',
  styleUrls: ['./userviewenquiry.component.css']
})
export class UserviewenquiryComponent implements OnInit {
  enquiries: Enquiry[] = []

  showPopUp : boolean = false
  enquiryIdToDelete : number | null = null
  
  currentUser:number;
  dtoObject:any;

  constructor(private enquiryService: EnquiryService,private router:Router) { }

  ngOnInit(): void {
    const loginDTOObj = localStorage.getItem('LoginDTOObj');
    console.log('LoginDTOObj from localStorage:', loginDTOObj);
    if (loginDTOObj) {
      this.dtoObject = JSON.parse(loginDTOObj);
      this.currentUser = this.dtoObject.userId;
      console.log("Current user id: " + this.currentUser);
    }
    
    this.getEnquiriesByUserId(this.currentUser)
  }
  getEnquiriesByUserId(userId: number) {
    this.enquiryService.getUserEnquiries(userId).subscribe((data) => {
      this.enquiries = data;
    });
  }

  deleteEnquiry(enquiryId:number){
    this.enquiryService.deleteEnquiry(enquiryId).subscribe(()=>{
      this.getEnquiriesByUserId(this.currentUser);
      console.log("Enquiry deleted successfully.")
    })
  }

  cancel(){
    this.router.navigate(['/userviewenquiry'])
  }

}
