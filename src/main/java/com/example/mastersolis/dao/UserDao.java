package com.example.mastersolis.dao;

import com.example.mastersolis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByPhonenumber(String emailOrPhone);

    Boolean existsByEmail(String email);
    Boolean existsByPhonenumber(String phonenumber);

}
