package com.example.mastersolis.service;

import com.example.mastersolis.dao.CourseInternInstructorListDao;
import com.example.mastersolis.dao.InternshipDao;
import com.example.mastersolis.model.CourseInternInstructorList;
import com.example.mastersolis.model.Internships;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InternshipService {
    @Autowired
    InternshipDao internshipDao;

    @Autowired
    CourseInternInstructorListDao courseInternInstructorListDao;

    public ResponseEntity<String> addInternShip(Internships internship) {
        try{
            internshipDao.save(internship);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error while saving the data", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully Added the Internship Details", HttpStatus.CREATED);
    }

    public ResponseEntity<String> addInstructorToInternship(CourseInternInstructorList courseInternInstructorList) {
        try{
            courseInternInstructorList.setCourse_id(null);
            courseInternInstructorListDao.save(courseInternInstructorList);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error in saving the data", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Added the details Successfully", HttpStatus.CREATED);
    }
}
