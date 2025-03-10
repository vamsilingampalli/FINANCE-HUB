
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { SavingsPlan } from 'src/app/models/savingsPlan.model';
import { PlanApplicationFormService } from 'src/app/services/plan-application-form.service';
import { SavingsPlanService } from 'src/app/services/savingsPlan.service';

@Component({
  selector: 'app-userplanapplicationform',
  templateUrl: './userplanapplicationform.component.html',
  styleUrls: ['./userplanapplicationform.component.css']
})
export class UserplanapplicationformComponent implements OnInit {

  planApplicationForm: FormGroup;
  isSubmitted: boolean = false;

  isModalOpen = false;
  proofDocument?: string;
  dtoObject: any;
  currentUser: number;
  savingsPlans: SavingsPlan[];

  imagePreview: string | ArrayBuffer | null = null;

  constructor(private fb: FormBuilder, private router: Router, private planApplicationFormService: PlanApplicationFormService, private savingsPlanService: SavingsPlanService) { }

  ngOnInit(): void {

    this.planApplicationForm = this.fb.group({
      appliedAmount: ['', [Validators.required, Validators.min(1)]],
      remarks: [''],
      applicationDate: ['', [Validators.required, this.noPastDateValidator]],
      proofDocument: ['', Validators.required],
      savingsPlanName: ['', Validators.required]
    });

    const loginDTOObj = localStorage.getItem('LoginDTOObj');
    if (loginDTOObj) {
      this.dtoObject = JSON.parse(loginDTOObj);
      this.currentUser = this.dtoObject.userId;
    }
    this.savingsPlanService.getAllSavingsPlans().subscribe((data) => {
      this.savingsPlans = data;
    })
  }

  onFileChange(event: any): void {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = () => {
        this.imagePreview = reader.result as string;
        this.planApplicationForm.get('proofDocument').setValue(this.imagePreview);
      }
      reader.readAsDataURL(file);
    }
  }

  openModal(): void {
    this.isModalOpen = true;
  }

  closeModal(): void {
    this.isModalOpen = false;
  }

  onSubmit(): void {
    if (this.planApplicationForm.valid) {
      
      const planApplication = {
        ...this.planApplicationForm.value,
        user: {
          userId: this.currentUser
        }
      };
      planApplication.status = 'Pending'; // Initialize status as pending at first.
      console.log(planApplication.savingsPlanName);
      this.planApplicationFormService.addPlanApplication(planApplication).subscribe(response => {

        console.log('Form submitted successfully!', response);
        this.isSubmitted = true;
      }, error => {
        console.error('Form submission error:', error);
      });
    } else {
      console.log('Form is invalid');
    }
  }

  redirectToAnotherRoute(): void {
    this.router.navigate(['/userappliedplans']);
  }

  noPastDateValidator(control: AbstractControl): { [key: string]: boolean } | null {
    const selectedDate = new Date(control.value);
    const currentDate = new Date();
    
    currentDate.setHours(0, 0, 0, 0);//this will only compare dates since its set to zero.
    return selectedDate < currentDate ? { 'pastDate': true } : null;
  }
}
