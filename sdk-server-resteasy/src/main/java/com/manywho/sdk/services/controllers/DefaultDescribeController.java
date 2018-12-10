package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.services.describe.DescribeManager;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/metadata")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DefaultDescribeController {
    private final DescribeManager describeManager;

    @Inject
    public DefaultDescribeController(DescribeManager describeManager) {
        this.describeManager = describeManager;
    }

    @POST
    public DescribeServiceResponse describe(@Valid @NotNull DescribeServiceRequest request) {
        return describeManager.describe(request);
    }
}
