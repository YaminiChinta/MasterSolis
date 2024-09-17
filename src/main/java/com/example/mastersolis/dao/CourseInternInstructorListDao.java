package com.example.mastersolis.dao;

import com.example.mastersolis.model.CourseInternInstructorList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseInternInstructorListDao extends JpaRepository<CourseInternInstructorList, Integer> {
}
