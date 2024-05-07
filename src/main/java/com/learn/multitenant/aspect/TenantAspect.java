package com.learn.multitenant.aspect;

import com.learn.multitenant.domain.tenantable.Tenantable;
import com.learn.multitenant.security.TenantContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TenantAspect {

    @Autowired
    private TenantContext tenantContext;

    @PersistenceContext
    private EntityManager entityManager;

    @Before("execution(* com.learn.multitenant.repository.TenantableRepository+.find*(..))")
    public void beforeFindOfTenantableRepository() {
        entityManager
                .unwrap(Session.class)
                .enableFilter(Tenantable.TENANT_FILTER_NAME)
                .setParameter(Tenantable.TENANT_PARAMETER_NAME, tenantContext.getTenantId());
    }
}