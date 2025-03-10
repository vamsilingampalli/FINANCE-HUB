import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SavingsPlanService } from 'src/app/services/savingsPlan.service';
 
@Component({
  selector: 'app-createsavingsplan',
  templateUrl: './createsavingsplan.component.html',
  styleUrls: ['./createsavingsplan.component.css']
})
export class CreatesavingsplanComponent implements OnInit {
  savingsplanForm:FormGroup;
 
  constructor(private savingsPlanService:SavingsPlanService,private formBuilder:FormBuilder,private router:Router) { }
 
  ngOnInit(): void {
    this.savingsplanForm=this.formBuilder.group({
      name:['',[Validators.required,Validators.pattern('^[a-zA-Z]+$'),Validators.minLength(7)]],
      goalAmount:[0,[Validators.required,Validators.pattern(/^\d+$/),Validators.min(0),Validators.maxLength(6)]],
      timeFrame:[0,[Validators.required,Validators.pattern(/^\d+$/),Validators.min(0)]],
      riskLevel:['',[Validators.required]],
      description:['',[Validators.required]],
      status:['',[Validators.required]]
    })
  }
 
  addNewSavingsPlan(){
    console.log(this.savingsplanForm.valid);
    console.log(this.savingsplanForm.value);
   
    if(this.savingsplanForm.valid){
      this.savingsPlanService.addSavingsPlan(this.savingsplanForm.value).subscribe(()=>{
      })
      this.router.navigate(['/viewsavingsplan']);
      alert("SavingsPlan added successfully!");
    }
  }
 
  get f(){
    return this.savingsplanForm.controls;
  }
 
}