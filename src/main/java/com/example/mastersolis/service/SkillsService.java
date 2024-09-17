package com.example.mastersolis.service;

import com.example.mastersolis.dao.SkillsDao;
import com.example.mastersolis.model.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillsService {

    @Autowired
    SkillsDao skillsDao;

    public ResponseEntity<String> addSkills(Skills skills) {
        try{
            skillsDao.save(skills);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error while saving the data", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Added the skills", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Skills>> getAllSkills() {
        List<Skills> skillsList=new ArrayList<>();
        try{
            skillsList=skillsDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(skillsList, HttpStatus.BAD_REQUEST);
        }return new ResponseEntity<>(skillsList, HttpStatus.OK);
    }

}
