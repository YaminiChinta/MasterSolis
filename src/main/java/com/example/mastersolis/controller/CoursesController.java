package com.example.mastersolis.controller;

import com.example.mastersolis.model.CourseInternInstructorList;
import com.example.mastersolis.model.Courses;
import com.example.mastersolis.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Courses")
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Courses course){
        return coursesService.addCourse(course);
    }

    @GetMapping("/getCourse/{id}")
    public ResponseEntity<Courses> getCourse(@PathVariable Integer id){
        return coursesService.getCourse(id);
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<Courses>> gelAllCourses(){
        return coursesService.getAllCourses();
    }

    @PostMapping("/addInstructorToCourse")
    public ResponseEntity<String> addInstructorToCourse(@RequestBody CourseInternInstructorList courseInternInstructorList){
        return coursesService.addInstructorToCourse(courseInternInstructorList);
    }
}
