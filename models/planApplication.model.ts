import { User } from "./user.model";

export interface PlanApplication {
    planApplicationId?:number;
    appliedAmount?:number;
    status?: string;
    applicationDate?: string;
    remarks?: string;
    proofDocument?: string;
    savingsPlanName?:string;
    user?:User;
    
    statusUpdated?:boolean;
}