import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { FeedbackService } from 'src/app/services/feedback.service';

@Component({
  selector: 'app-useraddfeedback',
  templateUrl: './useraddfeedback.component.html',
  styleUrls: ['./useraddfeedback.component.css']
})
export class UseraddfeedbackComponent implements OnInit {


  showPopup: boolean = false;
  currentUser: number;
  dtoObject: any;
  feedback: any = {
    feedbackText: '',
    date: new Date(),
    user: {
      userId: null
    }
  }
  

  constructor(private feedbackService: FeedbackService, private router: Router) { }

  ngOnInit(): void {
    const loginDTOObj = localStorage.getItem('LoginDTOObj');
    console.log('LoginDTOObj from localStorage:', loginDTOObj);
    if (loginDTOObj) {
      this.dtoObject = JSON.parse(loginDTOObj);
      this.currentUser = this.dtoObject.userId;
      console.log("Current user id: " + this.currentUser);
    }
  }
  addFeedback(form: NgForm) {
    this.feedback.user.userId = this.currentUser;
    this.feedbackService.sendFeedback(this.feedback).subscribe();
    this.showPopup = true;
    form.reset()
  }
  closePopup() {
    this.showPopup = false;
    this.router.navigate(['/userviewfeedback'])
  }
}