package com.learn.multitenant.domain.compositekey;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolePermissionKey implements Serializable {
    private Long roleId;
    private Long permissionId;
}
