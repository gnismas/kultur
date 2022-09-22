package com.example.kultur.reviewservice;


import com.example.kultur.model.Review;

import com.example.kultur.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewService implements IReviewService{
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Review save(Review object) {
        return reviewRepository.save(object);
    }

    @Override
    public Optional<Review> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Review> findAll() {
        return new ArrayList<>(reviewRepository.findAll());
    }

}

