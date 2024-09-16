package com.example.mastersolis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String course_name;
    private String price;
    private String duration;

    @Column(length = 10000)
    private String description;

    @Column(length = 40000)
    private String about;
    @OneToMany
    private List<Instructor> instructorList;
}
