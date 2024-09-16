package com.example.mastersolis.dao;

import com.example.mastersolis.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesDao extends JpaRepository<Courses, Integer> {
}
