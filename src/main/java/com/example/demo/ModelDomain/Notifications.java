package com.example.demo.ModelDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

import com.example.demo.ModelDomain.NotificationsType;
import com.example.demo.ModelDomain.User;;

@Entity
public class Notifications {
    
    @Id
    @GeneratedValue
    private Long id;

    private String message;
    private boolean isRead = false;

    private LocalDateTime createdAt = LocalDateTime.now();  

    @Enumerated(EnumType.STRING)
    private NotificationsType notificationTyoe;

    @ManyToOne
    @JoinColumn(name  = "user", nullable = false)
    private User user;

}
