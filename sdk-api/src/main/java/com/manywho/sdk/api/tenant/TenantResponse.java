package com.manywho.sdk.api.tenant;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
public class TenantResponse extends TenantRequest {
    private String developerName;
    private UUID id;
    private List<TenantResponse> subTenants;

    @Builder
    public TenantResponse(String developerName, String developerSummary, UUID id, ReportSettings reportSettings, SecuritySettings securitySettings, StateSettings stateSettings, String subdomain, TenantSettings tenantSettings, List<TenantResponse> subTenants) {
        super(developerSummary, reportSettings, securitySettings, stateSettings, subdomain, tenantSettings);
        this.developerName = developerName;
        this.id = id;
        this.subTenants = subTenants;
    }
}
