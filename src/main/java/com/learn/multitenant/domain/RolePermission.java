package com.learn.multitenant.domain;

import com.learn.multitenant.domain.compositekey.RolePermissionKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "role_permissions")
@IdClass(RolePermissionKey.class)
public class RolePermission {
    @Id
    private Long roleId;
    @Id
    private Long permissionId;
}
