package com.example.mastersolis.dao;

import com.example.mastersolis.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
    Users findByPhonenumber(String emailOrPhone);

    Boolean existsByEmail(String email);
    Boolean existsByPhonenumber(String phonenumber);

}
