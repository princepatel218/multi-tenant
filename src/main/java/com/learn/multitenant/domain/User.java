package com.learn.multitenant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID tenantId;
    private String name;
    private String email;
    private String password;
    private Boolean isActive;
    private Timestamp createdTimestamp;
    private Timestamp updatedTimestamp;
    private Long createdBy;
    private Long updatedBy;
}
