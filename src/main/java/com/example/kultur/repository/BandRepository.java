package com.example.kultur.repository;

import com.example.kultur.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band,Long> {
}