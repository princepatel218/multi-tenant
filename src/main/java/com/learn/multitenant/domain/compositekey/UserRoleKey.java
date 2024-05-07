package com.learn.multitenant.domain.compositekey;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRoleKey implements Serializable {
    private Long userId;
    private Long roleId;
}
