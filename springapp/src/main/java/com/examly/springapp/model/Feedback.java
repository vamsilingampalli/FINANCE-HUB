//Feedback class
/*
 * this is feedback class
 * to know the Feedback details:
 * In this class we have the required attributes (feedbackId, feedbackText, date)
 * we map this FeedBack class with user
 * @Author Team 17
 */
package com.examly.springapp.model;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    /**
     * The unique ID of the feedback.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedbackId;
    /**
     * The text content of the feedback.
     */
    private String feedbackText;
    /**
     * The date when the feedback was provided.
     */
    private LocalDate date;
    /**
     * The user who provided the feedback.
     */
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    
}

