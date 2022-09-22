package com.example.kultur.controller;

import com.example.kultur.eventservice.IEventService;
import com.example.kultur.model.Event;
import com.example.kultur.model.Review;
import com.example.kultur.reviewservice.IReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class ReviewController {
    private IEventService iEventService;
    private IReviewService iReviewService;
    @PostMapping("/createReview")
    public ResponseEntity<String> createReview(@RequestBody Review review, @RequestParam Long eventID)     {
        Optional<Event> event_ = iEventService.findById(eventID);
        if (event_.isPresent()){
            review.setEvent(event_.get());
           iReviewService.save(review);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Could not create", HttpStatus.OK);
        }

    }
    @GetMapping("/getAllEvents")
    public ResponseEntity<String> read() {
        if (!iReviewService.findAll().isEmpty()) {
            return new ResponseEntity<>("All reviews: " + iReviewService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Table is empty!", HttpStatus.OK);
        }
    }
}
