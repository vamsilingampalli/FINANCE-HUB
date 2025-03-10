import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SavingsPlan } from 'src/app/models/savingsPlan.model';
import { SavingsPlanService } from 'src/app/services/savingsPlan.service';

@Component({
  selector: 'app-userviewsavingsplan',
  templateUrl: './userviewsavingsplan.component.html',
  styleUrls: ['./userviewsavingsplan.component.css']
})
export class UserviewsavingsplanComponent implements OnInit {
savingsPlans:SavingsPlan[]=[];
searchText:string='';
filteredPlans:SavingsPlan[]=[];
  constructor(private savingsPlanService:SavingsPlanService,private router:Router) { }

  ngOnInit(): void {
    this.getAllSavingsPlans();
  }

    getAllSavingsPlans(){
      this.savingsPlanService.getAllSavingsPlans().subscribe((data)=>{
        this.savingsPlans=data;
        this.filteredPlans=data;
      })
    }

    navigateToApplicationForm(){
      this.router.navigate(['/userplanapplicationform']);
    }


    filterPlans(){
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

}
