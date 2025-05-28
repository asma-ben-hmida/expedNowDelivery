package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.ModelDomain.Notifications;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications , Long>  {

    
}
