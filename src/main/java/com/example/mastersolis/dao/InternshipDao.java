package com.example.mastersolis.dao;

import com.example.mastersolis.model.Internships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternshipDao extends JpaRepository<Internships, Integer> {
}
