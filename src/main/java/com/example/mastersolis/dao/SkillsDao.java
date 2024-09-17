package com.example.mastersolis.dao;

import com.example.mastersolis.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsDao extends JpaRepository<Skills, Integer> {
}
