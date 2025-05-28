package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User , Long>{

    
    List<User>  findByRoleNot (UserRole role);
    Optional<User> findByUserName(String username);
    List<User> findAllByRoleIn(List<UserRole> roles);


}