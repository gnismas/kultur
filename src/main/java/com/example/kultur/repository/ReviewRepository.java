package com.example.kultur.repository;

import com.example.kultur.model.Band;
import com.example.kultur.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
