package com.learn.multitenant.security;

import com.learn.multitenant.service.UserDetailsImpl;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver<UUID>, HibernatePropertiesCustomizer {


    // Application won't start if this returns null or throws any exception
    @Override
    public UUID resolveCurrentTenantIdentifier() {
        try {
            return ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getTenantId();
        } catch (Exception e) {
            return UUID.randomUUID();
        }
    }
    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
    }
}
