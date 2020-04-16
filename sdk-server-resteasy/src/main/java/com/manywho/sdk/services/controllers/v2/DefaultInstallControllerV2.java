package com.manywho.sdk.services.controllers.v2;

import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.services.describe.DescribeManagerV2;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/metadata/install")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DefaultInstallControllerV2 {
    private final DescribeManagerV2 describeManager;

    @Inject
    public DefaultInstallControllerV2(DescribeManagerV2 describeManager) {
        this.describeManager = describeManager;
    }

    @POST
    public DescribeServiceResponse install(@Valid @NotNull DescribeServiceRequest request) {
        return describeManager.install(request);
    }
}