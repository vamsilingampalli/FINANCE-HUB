import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Enquiry } from 'src/app/models/enquiry.model';
import { EnquiryService } from 'src/app/services/enquiry.service';

@Component({
  selector: 'app-managerviewenquiries',
  templateUrl: './managerviewenquiries.component.html',
  styleUrls: ['./managerviewenquiries.component.css']
})
export class ManagerviewenquiriesComponent implements OnInit {

  // enquiry: Enquiry = {
  //   message: '',
  //   user:{
  //     email: '',
  //     password: '',
  //     username: '',
  //     mobileNumber: '',
  //     userRole: ''
  //   }
  // }
  enquiries: Enquiry[] = []
  searchText: string = ''

  constructor(private enquiryService: EnquiryService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAllEnquiries()
  }

  getAllEnquiries() {
    this.enquiryService.getAllEnquiry().subscribe((data) => {
      this.enquiries = data;
    });
  }


  getAllByEnquiryId(enquiryId: number) {
    this.enquiryService.getEnquiryById(enquiryId).subscribe(() => {
      this.enquiries.filter(f => f.enquiryId === enquiryId)
    })

  }
}
