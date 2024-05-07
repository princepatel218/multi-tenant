package com.learn.multitenant.domain.tenantable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.multitenant.listener.TenantEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.util.UUID;


@Data
@MappedSuperclass
@FilterDef(name = Tenantable.TENANT_FILTER_NAME,
        parameters = @ParamDef(name = Tenantable.TENANT_PARAMETER_NAME, type = UUID.class),
        defaultCondition = Tenantable.TENANT_COLUMN + " = :" + Tenantable.TENANT_PARAMETER_NAME)
@Filter(name = Tenantable.TENANT_FILTER_NAME)
@EntityListeners(TenantEntityListener.class)
public class Tenantable extends Auditable {
    public static final String TENANT_FILTER_NAME = "tenantFilter";
    public static final String TENANT_PARAMETER_NAME = "tenantId";
    public static final String TENANT_COLUMN = "tenant_id";

    @JsonIgnore
    @Column(nullable = false)
    private UUID tenantId;
}
