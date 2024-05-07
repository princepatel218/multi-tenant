package com.learn.multitenant.domain.compositekey;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class FeatureUsageKey implements Serializable {
    private UUID tenantId;
    private Long featureId;
}
