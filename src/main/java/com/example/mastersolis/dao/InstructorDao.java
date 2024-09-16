package com.example.mastersolis.dao;

import com.example.mastersolis.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorDao extends JpaRepository<Instructor, Integer> {
    @Query(nativeQuery = true,value = "select * from instructor order by random() limit 1 ")
    List<Instructor> getInstructorByRandom();
}
