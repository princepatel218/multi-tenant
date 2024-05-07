package com.learn.multitenant.domain;

import com.learn.multitenant.domain.compositekey.UserRoleKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user_roles")
@IdClass(UserRoleKey.class)
public class UserRole {
    @Id
    private Long userId;
    @Id
    private Long roleId;
    private Boolean isActive;
    private Timestamp createdTimestamp;
    private Timestamp updatedTimestamp;
    private Long createdBy;
    private Long updatedBy;
}
