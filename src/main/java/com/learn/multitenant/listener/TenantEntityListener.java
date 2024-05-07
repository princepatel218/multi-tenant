package com.learn.multitenant.listener;

import com.learn.multitenant.domain.tenantable.Tenantable;
import com.learn.multitenant.security.TenantContext;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TenantEntityListener {

    @Autowired
    private TenantContext tenantContext;

    @PrePersist
    @PreUpdate
    public void prePersistOrUpdate(Object object) {
        if (object instanceof Tenantable) {
            ((Tenantable) object).setTenantId(tenantContext.getTenantId());
        }
    }

    @PreRemove
    public void preRemove(Object object) {
        if (object instanceof Tenantable && ((Tenantable) object).getTenantId() != tenantContext.getTenantId()) {
            throw new EntityNotFoundException();
        }
    }

}
