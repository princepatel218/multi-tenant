package com.learn.multitenant.repository;

import com.learn.multitenant.domain.SomeOtherTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SomeOtherTableRepository extends JpaRepository<SomeOtherTable, Long> {
}
