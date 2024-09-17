package com.example.mastersolis.service;

import com.example.mastersolis.dao.CourseInternInstructorListDao;
import com.example.mastersolis.dao.CoursesDao;
import com.example.mastersolis.dao.InstructorDao;
import com.example.mastersolis.model.CourseInternInstructorList;
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
    CourseInternInstructorListDao courseInternInstructorListDao;

    @Autowired
    InstructorDao instructorDao;

    public ResponseEntity<String> addCourse(Courses course) {
        try {
            coursesDao.save(course);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error while saving the data", HttpStatus.BAD_REQUEST);
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

    public ResponseEntity<String> addInstructorToCourse(CourseInternInstructorList courseInternInstructorList) {
        try{
            courseInternInstructorList.setInternship_id(null);
            courseInternInstructorListDao.save(courseInternInstructorList);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error in saving the data", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Added the details Successfully", HttpStatus.CREATED);
    }
}
