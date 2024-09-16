package com.example.mastersolis.controller;

import com.example.mastersolis.model.Instructor;
import com.example.mastersolis.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Instructor")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @PostMapping("/addInstructor")
    public ResponseEntity<String> addInstructor(@RequestBody Instructor instructor){
        return instructorService.addInstructor(instructor);
    }

    @GetMapping("/getInstructor/{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable Integer id){
        return instructorService.getInstructor(id);
    }

    @GetMapping("/getAllInstructors")
    public ResponseEntity<List<Instructor>> getAllInstructors(){
        return instructorService.getAllInstructors();
    }
}
