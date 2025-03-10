import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SavingsPlan } from 'src/app/models/savingsPlan.model';
import { AuthService } from 'src/app/services/auth.service';
import { SavingsPlanService } from 'src/app/services/savingsPlan.service';

@Component({
  selector: 'app-viewsavingsplan',
  templateUrl: './viewsavingsplan.component.html',
  styleUrls: ['./viewsavingsplan.component.css']
})
export class ViewsavingsplanComponent implements OnInit {
  savingsPlans: SavingsPlan[] = [];
  filteredPlans: SavingsPlan[] = [];
  searchText: string = '';
  showConfirmDialog: boolean = false;
  savingsPlanIdToDelete: number | null = null;
  constructor(private savingsPlanService: SavingsPlanService, private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
    this.getAllSavingsPlans();
    console.log(this.authService.getAuthToken());
  }

  getAllSavingsPlans() {
    this.savingsPlanService.getAllSavingsPlans().subscribe((data) => {
      this.savingsPlans = data;
      this.filteredPlans=data;
    })
  }

  deleteSavingsPlan(id: number) {
    if (!this.authService.isLoggedIn()) {
      // Redirect to login or show an error message
      this.router.navigate(['/login']);
      return;
    }

    this.savingsPlanIdToDelete = id;
    this.showConfirmDialog = true;
  }



  confirmDelete(confirm: boolean): void {
    console.log("Service, Delete triggred");
    if (confirm && this.savingsPlanIdToDelete !== null) {
      console.log("Service, delete id: ", this.savingsPlanIdToDelete);
      this.savingsPlanService.deleteSavingsPlan(this.savingsPlanIdToDelete).subscribe(() => {
        // Optionally refetch the updated list of savings plans from the server
        this.getAllSavingsPlans();
        this.showConfirmDialog = false;
        this.savingsPlanIdToDelete = null;
      },
      error=>{
        console.log(error);
      });
    } else {
      this.showConfirmDialog = false;
      this.savingsPlanIdToDelete = null;
    }
  }


  filterPlans() {
    console.log("search called")
    if (this.searchText) {
      this.filteredPlans = this.savingsPlans.filter(plan =>
        plan.name.toLowerCase().includes(this.searchText.toLowerCase()) ||
        plan.goalAmount.toString().includes(this.searchText) ||
        plan.timeFrame.toString().includes(this.searchText) ||
        plan.riskLevel.toLowerCase().includes(this.searchText.toLowerCase()) ||
        plan.description.toLowerCase().includes(this.searchText.toLowerCase()) ||
        plan.status.toLowerCase().includes(this.searchText.toLowerCase())
      );
    } else {
      this.filteredPlans = this.savingsPlans;
    }

  }

  navigateToUpdateSavingsPlan(id:number){
    this.router.navigate(['/managereditsavingsplan',id]);
  }
}
