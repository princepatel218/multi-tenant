package com.learn.multitenant.repository;

import com.learn.multitenant.domain.UserRole;
import com.learn.multitenant.domain.compositekey.UserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleKey> {

    List<UserRole> findAllByUserId(long userId);

}
