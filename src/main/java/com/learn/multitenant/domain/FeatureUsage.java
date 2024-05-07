package com.learn.multitenant.domain;

import com.learn.multitenant.domain.compositekey.FeatureUsageKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "feature_usages")
@Data
@IdClass(FeatureUsageKey.class)
public class FeatureUsage {
    @Id
    private UUID tenantId;
    @Id
    private Long featureId;
    private Long overrideDefaultQuota;
    private Timestamp createdTimestamp;
    private Timestamp updatedTimestamp;
}
