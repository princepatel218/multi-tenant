package com.learn.multitenant.repository;

import com.learn.multitenant.domain.RolePermission;
import com.learn.multitenant.domain.compositekey.RolePermissionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermissionKey> {

    List<RolePermission> findAllByRoleIdIn(Collection<Long> roleId);

}
