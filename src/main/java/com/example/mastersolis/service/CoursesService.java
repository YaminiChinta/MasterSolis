package com.example.mastersolis.service;

import com.example.mastersolis.dao.CoursesDao;
import com.example.mastersolis.dao.InstructorDao;
import com.example.mastersolis.model.Courses;
import com.example.mastersolis.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesService {

    @Autowired
    CoursesDao coursesDao;

    @Autowired
    InstructorDao instructorDao;

    public ResponseEntity<String> addCourse(Courses course) {
        List<Instructor> instructorList=instructorDao.getInstructorByRandom();
        try {
            course.setInstructorList(instructorList);
            coursesDao.save(course);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Added Course Details Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<Courses> getCourse(Integer id) {
        Courses course=new Courses();
        try {
            course=coursesDao.findById(id).orElseThrow();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    public ResponseEntity<List<Courses>> getAllCourses() {
        List<Courses> coursesList=new ArrayList<>();
        try {
            coursesList=coursesDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(coursesList, HttpStatus.OK);
    }
}
