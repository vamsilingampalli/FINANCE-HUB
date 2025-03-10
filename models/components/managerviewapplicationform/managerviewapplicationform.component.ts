
import { Component, OnInit } from '@angular/core';
import { PlanApplication } from 'src/app/models/planApplication.model';
import { PlanApplicationFormService } from 'src/app/services/plan-application-form.service';

@Component({
  selector: 'app-managerviewapplicationform',
  templateUrl: './managerviewapplicationform.component.html',
  styleUrls: ['./managerviewapplicationform.component.css']
})
export class ManagerviewapplicationformComponent implements OnInit {
  planApplications: PlanApplication[] = [];
  selectedRequest: PlanApplication | null = null;
  activeSort: string = '';

  isModalOpen = false;
  selectedImage: string | undefined;

  constructor(private planApplicationFormService: PlanApplicationFormService) { }

  ngOnInit(): void {

    this.planApplications.forEach(application => {
      this.convertBlobToBase64(application);
    });

    
    this.getAllPlanApplications();
  }

  getAllPlanApplications() {
    this.planApplicationFormService.getAllPlanApplications().subscribe((data) => {
      console.log("Successfully pulled from backend");
      this.planApplications = data;
    });
  }

  viewImage(application: PlanApplication): void {
    console.log(application.proofDocument);
    this.selectedImage = application.proofDocument;
    this.openModal();
  }

  openModal(): void {
    console.log("model is opened");
    this.isModalOpen = true;
  }

  closeModal(): void {
    this.isModalOpen = false;
  }

  private convertBlobToBase64(application: PlanApplication): void {
    const blob = new Blob(['Proof Document'], { type: 'application/pdf' });
    const reader = new FileReader();
    reader.onload = () => {
      application.proofDocument = reader.result as string;
    };
    reader.readAsDataURL(blob);
  }

  sortAscending(): void {
    this.activeSort = 'asc';
    this.planApplications.sort((a, b) => a.appliedAmount - b.appliedAmount);
  }

  sortDescending(): void {
    this.activeSort = 'desc';
    this.planApplications.sort((a, b) => b.appliedAmount - a.appliedAmount);
  }

  updateStatus(id: number, application: PlanApplication, status: string): void {
    application.status = status;
    application.statusUpdated = true;
    this.planApplicationFormService.updatePlanApplication(id, application).subscribe();
  }
}
