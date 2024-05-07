package com.learn.multitenant.repository;

import com.learn.multitenant.domain.SomeTable;

public interface SomeTableRepository extends TenantableRepository<SomeTable, Long> {
}
