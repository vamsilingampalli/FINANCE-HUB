import { Component, OnInit } from '@angular/core';
import { PlanApplication } from 'src/app/models/planApplication.model';
import { PlanApplicationFormService } from 'src/app/services/plan-application-form.service';

@Component({
  selector: 'app-userappliedplans',
  templateUrl: './userappliedplans.component.html',
  styleUrls: ['./userappliedplans.component.css']
})
export class UserappliedplansComponent implements OnInit {

  planApplications: PlanApplication[] = [];
  dtoObject: any;
  currentUser: number;
  activeSort: string = '';

  isModalOpen = false;
  selectedImage: string | undefined;

  constructor(private planApplicationFormService: PlanApplicationFormService) { }
  
  
  ngOnInit(): void {
    this.planApplications.forEach(application => {
      this.convertBlobToBase64(application);
    });

    const loginDTOObj = localStorage.getItem('LoginDTOObj');
    console.log('LoginDTOObj from localStorage:', loginDTOObj);
    if (loginDTOObj) {
      this.dtoObject = JSON.parse(loginDTOObj);
      this.currentUser = this.dtoObject.userId;
      console.log("Current user id: " + this.currentUser);
    }
    this.getAllPlanApplications();
  }
  
  viewImage(imageData: string): void {
    console.log(imageData);
    this.selectedImage = imageData;
    this.openModal();
  }

  openModal(): void {
    console.log("model is opened");
    this.isModalOpen = true;
  }

  closeModal(): void {
    this.isModalOpen = false;
  }


  


  getAllPlanApplications() {
    console.log(this.currentUser);
    this.planApplicationFormService.getAppliedPlans(this.currentUser).subscribe((data) => {
      console.log("Successfully pulled from backend");
      this.planApplications = data;
    });
  }

  sortAscending(): void {
    this.activeSort = 'asc';
    this.planApplications.sort((a, b) => a.appliedAmount - b.appliedAmount);
  }

  sortDescending(): void {
    this.activeSort = 'desc';
    this.planApplications.sort((a, b) => b.appliedAmount - a.appliedAmount);
  }

  private convertBlobToBase64(application: PlanApplication): void {
    const blob = new Blob(['Proof Document'], { type: 'application/pdf' });
    const reader = new FileReader();
    reader.onload = () => {
      application.proofDocument = reader.result as string;
    };
    reader.readAsDataURL(blob);
  }
}