package com.example.mastersolis.controller;

import com.example.mastersolis.model.Skills;
import com.example.mastersolis.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Skills")
public class SkillsController {

    @Autowired
    SkillsService skillsService;

    @PostMapping("/addSkill")
    public ResponseEntity<String> addSkill(@RequestBody Skills skills){
        return skillsService.addSkills(skills);
    }

    @GetMapping("/getAllSkills")
    public ResponseEntity<List<Skills>> getAllSkills(){
        return skillsService.getAllSkills();
    }
}
