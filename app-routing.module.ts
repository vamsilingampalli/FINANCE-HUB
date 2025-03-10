import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { HomeComponent } from './components/home/home.component';
import { AdminviewfeedbackComponent } from './components/adminviewfeedback/adminviewfeedback.component';
import { ManagereditenquiryComponent } from './components/managereditenquiry/managereditenquiry.component';
import { ManagereditsavingsplanComponent } from './components/managereditsavingsplan/managereditsavingsplan.component';
import { ManagerviewapplicationformComponent } from './components/managerviewapplicationform/managerviewapplicationform.component';
import { ManagerviewenquiriesComponent } from './components/managerviewenquiries/managerviewenquiries.component';
import { UseraddenquiryComponent } from './components/useraddenquiry/useraddenquiry.component';
import { UseraddfeedbackComponent } from './components/useraddfeedback/useraddfeedback.component';
import { UserappliedplansComponent } from './components/userappliedplans/userappliedplans.component';
import { UserplanapplicationformComponent } from './components/userplanapplicationform/userplanapplicationform.component';
import { UserviewenquiryComponent } from './components/userviewenquiry/userviewenquiry.component';
import { UserviewfeedbackComponent } from './components/userviewfeedback/userviewfeedback.component';
import { UserviewformComponent } from './components/userviewform/userviewform.component';
import { UserviewsavingsplanComponent } from './components/userviewsavingsplan/userviewsavingsplan.component';
import { ViewsavingsplanComponent } from './components/viewsavingsplan/viewsavingsplan.component';
import { ErrorComponent } from './components/error/error.component';
import { CreatesavingsplanComponent } from './components/createsavingsplan/createsavingsplan.component';
import { AuthguardService } from './services/authguard.service';
 
const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'error', component: ErrorComponent },
  { path: '', component: HomeComponent },
 
 
  {
    path: 'adminviewfeedback',
    component: AdminviewfeedbackComponent,
    canActivate: [AuthguardService],
    data: { role: 'MANAGER' }
  },
  {
    path: 'createsavingsplan',
    component: CreatesavingsplanComponent,
    canActivate: [AuthguardService],
    data: { role: 'MANAGER' }
  },
  {
    path: 'managereditenquiry/:id',
    component: ManagereditenquiryComponent,
    canActivate: [AuthguardService],
    data: { role: 'MANAGER' }
  },
  {
    path: 'managerviewapplicationform',
    component: ManagerviewapplicationformComponent,
    canActivate: [AuthguardService],
    data: { role: 'MANAGER' }
  },
  {
    path: 'managerviewenquiries',
    component: ManagerviewenquiriesComponent,
    canActivate: [AuthguardService],
    data: { role: 'MANAGER' }
  },
  {
    path: 'managereditsavingsplan/:id',
    component: ManagereditsavingsplanComponent,
    canActivate: [AuthguardService],
    data: { role: 'MANAGER' }
  },
  {
    path: 'useraddenquiries',
    component: UseraddenquiryComponent,
    canActivate: [AuthguardService],
    data: { role: 'CLIENT' }
  },
  {
    path: 'useraddfeedback',
    component: UseraddfeedbackComponent,
    canActivate: [AuthguardService],
    data: { role: 'CLIENT' }
  },
  {
    path: 'userappliedplans',
    component: UserappliedplansComponent,
    canActivate: [AuthguardService],
    data: { role: 'CLIENT' }
  },
  {
    path: 'userplanapplicationform',
    component: UserplanapplicationformComponent,
    canActivate: [AuthguardService],
    data: { role: 'CLIENT' }
  },
  {
    path: 'userviewfeedback',
    component: UserviewfeedbackComponent,
    canActivate: [AuthguardService],
    data: { role: 'CLIENT' }
  },
  {
    path: 'userviewenquiry',
    component: UserviewenquiryComponent,
    canActivate: [AuthguardService],
    data: { role: 'CLIENT' }
  },
  {
    path: 'userviewform',
    component: UserviewformComponent,
    canActivate: [AuthguardService],
    data: { role: 'CLIENT' }
  },
  {
    path: 'userviewsavingsplan',
    component: UserviewsavingsplanComponent,
    canActivate: [AuthguardService],
    data: { role: 'CLIENT' }
  },
  {
    path: 'viewsavingsplan',
    component: ViewsavingsplanComponent,
    canActivate: [AuthguardService],
    data: { role: 'MANAGER' }
  },
  { path: '**', redirectTo: '/error' }
];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
 