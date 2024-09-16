package com.example.mastersolis.service;

import com.example.mastersolis.dao.InstructorDao;
import com.example.mastersolis.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    InstructorDao instructorDao;

    public ResponseEntity<String> addInstructor(Instructor instructor) {
        try{
            instructorDao.save(instructor);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Added the Instructor Details", HttpStatus.CREATED);
    }

    public ResponseEntity<Instructor> getInstructor(Integer id) {
        Instructor instructor = new Instructor();
        try{
            instructor=instructorDao.findById(id).orElseThrow();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructorList = new ArrayList<>();
        try{
            instructorList=instructorDao.findAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(instructorList, HttpStatus.OK);
    }
}
