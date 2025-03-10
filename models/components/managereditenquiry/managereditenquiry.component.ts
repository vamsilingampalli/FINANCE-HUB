import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Enquiry } from 'src/app/models/enquiry.model';
import { AuthService } from 'src/app/services/auth.service';
import { EnquiryService } from 'src/app/services/enquiry.service';

@Component({
  selector: 'app-managereditenquiry',
  templateUrl: './managereditenquiry.component.html',
  styleUrls: ['./managereditenquiry.component.css']
})
export class ManagereditenquiryComponent implements OnInit {
  id: number;

  currUserId: number;

  enquiry: any = {
    message: '',
    status: '',
    user: {
      userId: null
    }
  };

  constructor(private enquiryService: EnquiryService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    console.log('ngOnInit called'); // Log the start of ngOnInit
    this.activatedRoute.paramMap.subscribe(params => {
      const paramId = params.get('id');
      console.log('ParamMap:', params);
      console.log('paramId:', paramId);
      this.id = Number(paramId);
      console.log('Retrieved Enquiry ID:', this.id);

      if (this.id) {
        this.enquiryService.getEnquiryById(this.id).subscribe(data => {
          this.enquiry = data;
          console.log('Enquiry Data:', data);
        });
      }
    });

    // getting the loginDTO obj for the current user Id
    const loginDTOObj = localStorage.getItem('LoginDTOObj');
    this.currUserId = JSON.parse(loginDTOObj).userId;
    console.log("Currently logged in user id: ", this.currUserId);
  }


  updateEnquiry(enquiryId: number, status: string): void {
    this.enquiry.status = status;
    console.log("Enquiry obj: ", this.enquiry);
    console.log("Enquiry status from form: ", status);
    this.enquiryService.updateEnquiry(enquiryId, this.enquiry).subscribe(data => {
      console.log("Updated data:", data);
      this.router.navigate(['/managerviewenquiries']);
    });
  }
  

}
