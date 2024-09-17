package com.example.mastersolis.controller;

import com.example.mastersolis.model.CourseInternInstructorList;
import com.example.mastersolis.model.Internships;
import com.example.mastersolis.service.InternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Internships")
public class InternshipController {

    @Autowired
    InternshipService internshipService;

    @PostMapping("/addInternship")
    public ResponseEntity<String> addInternship(@RequestBody Internships internship){
        return internshipService.addInternShip(internship);
    }

    @PostMapping("/addInstructorToInternship")
    public ResponseEntity<String> addInstructorToInternship(@RequestBody CourseInternInstructorList courseInternInstructorList){
        return internshipService.addInstructorToInternship(courseInternInstructorList);
    }
}
