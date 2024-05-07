package com.learn.multitenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface TenantableRepository<T, K> extends JpaRepository<T, K> {
    Optional<T> findOneById(K id);
}
