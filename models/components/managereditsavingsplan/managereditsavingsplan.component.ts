
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SavingsPlan } from 'src/app/models/savingsPlan.model';
import { SavingsPlanService } from 'src/app/services/savingsPlan.service';

@Component({
  selector: 'app-managereditsavingsplan',
  templateUrl: './managereditsavingsplan.component.html',
  styleUrls: ['./managereditsavingsplan.component.css']
})
export class ManagereditsavingsplanComponent implements OnInit {
  savingsplan: SavingsPlan = ({
    name: '',
    goalAmount: 0,
    timeFrame: 0,
    riskLevel: 'Low',
    description: '',
    status: 'InActive'
  });
  id:number;

  constructor(private savingsPlanService: SavingsPlanService, private activatedRoute: ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.id = Number(this.activatedRoute.snapshot.paramMap.get('id'));
    if (this.id) {
      console.log(this.id);
      
      this.savingsPlanService.getSavingsPlanById(this.id).subscribe((data) => {
        this.savingsplan = data;
        console.log(data);
      });
    }
  }

  saveSavingsPlan(id:number){
    this.savingsPlanService.updateSavingsPlan(this.id,this.savingsplan).subscribe(()=>{
      this.router.navigate(['/viewsavingsplan']); 
    });
  }

}
