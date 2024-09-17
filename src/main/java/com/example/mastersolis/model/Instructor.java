package com.example.mastersolis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String instructor_name;
    @ManyToMany
    @JoinTable(name = "instructor_skill", joinColumns=@JoinColumn(name="instructor_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skills> skills;
}
