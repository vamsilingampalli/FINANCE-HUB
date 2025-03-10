
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EnquiryService } from 'src/app/services/enquiry.service';
 
 
@Component({
  selector: 'app-useraddenquiry',
  templateUrl: './useraddenquiry.component.html',
  styleUrls: ['./useraddenquiry.component.css']
})
export class UseraddenquiryComponent implements OnInit {
  enquiry:any={
    message: '',
    user:{
      userId:null
    }
  }
  dtoObject: any;
  constructor(private enquiryService: EnquiryService, private fb: FormBuilder, private router: Router) {}
  ni:number=0;
  ngOnInit(): void {
   
    const loginDTOObj = localStorage.getItem('LoginDTOObj');
    console.log('LoginDTOObj from localStorage:', loginDTOObj);
    if (loginDTOObj) {
      this.dtoObject = JSON.parse(loginDTOObj);
      this.ni=this.dtoObject.userId;
      console.log(this.ni);
      
   // Initialize the user ID
      console.log('Parsed DTO Object:', this.dtoObject);
      // console.log('Current User ID:', this.currentUserId);
    } else {
      console.error("Error: User is not logged in or LoginDTOObj is missing");
    }
  }
 
  addEnquiry() {
    if(this.enquiry.message.trim().length>0){

      this.enquiry.user.userId=this.ni;
      this.enquiryService.addEnquiry(this.enquiry).subscribe(() => {
        this.router.navigate(['/userviewenquiry'])
      })
    }
    
     else {
      alert("Please enter the message!!")
    }
  }
}
 
 
 
