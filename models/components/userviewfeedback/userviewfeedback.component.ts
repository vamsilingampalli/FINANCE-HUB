import { Component, OnInit } from '@angular/core';
import { Feedback } from 'src/app/models/feedback.model';
import { FeedbackService } from 'src/app/services/feedback.service';

@Component({
  selector: 'app-userviewfeedback',
  templateUrl: './userviewfeedback.component.html',
  styleUrls: ['./userviewfeedback.component.css']
})
export class UserviewfeedbackComponent implements OnInit {

  feedback: Feedback[] = [];
  showPopup: boolean = false;
  feedbackIdToDelete: number | null = null;
  currentUser:number;
  dtoObject:any;

  constructor(private feedbackService: FeedbackService) { }

  ngOnInit(): void {
    const loginDTOObj = localStorage.getItem('LoginDTOObj');
    if (loginDTOObj) {
      this.dtoObject = JSON.parse(loginDTOObj);
      this.currentUser = this.dtoObject.userId;
      console.log("Current user id: " + this.currentUser);
    }
    this.getFeedbacksByUserId(this.currentUser);
  }

  getAllFeedbacks() {
    this.feedbackService.getFeedbacks().subscribe((data) => {
      this.feedback = data;
    });
  }

  getFeedbacksByUserId(userId: number) {
    this.feedbackService.getAllFeedbacksByUserId(userId).subscribe((data) => {
      this.feedback = data;
    });
  }

  confirmDelete(feedbackId: number) {
    this.feedbackIdToDelete = feedbackId;
    this.showPopup = true;
  }

  deleteFeedback() {
    if (this.feedbackIdToDelete !== null) {
      this.feedbackService.deleteFeedback(this.feedbackIdToDelete).subscribe(() => {
        this.feedback = this.feedback.filter(f => f.feedbackId !== this.feedbackIdToDelete);
        this.closePopup();
      });
    }
  }

  closePopup() {
    this.showPopup = false;
    this.feedbackIdToDelete = null;
  }
}
