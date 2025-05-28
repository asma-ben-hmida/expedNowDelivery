package com.example.demo.ModelDTO;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NotificationsDTO {
    private Long id;
    private String message;
    private boolean isRead;
    private LocalDateTime createdAt;
    private String notificationType;
    private Long userId;

    // Constructeur complet
    public NotificationsDTO(Long id, String message, boolean isRead, LocalDateTime createdAt,
                            String notificationType, Long userId) {
        this.id = id;
        this.message = message;
        this.isRead = isRead;
        this.createdAt = createdAt;
        this.notificationType = notificationType;
        this.userId = userId;
    }
}
