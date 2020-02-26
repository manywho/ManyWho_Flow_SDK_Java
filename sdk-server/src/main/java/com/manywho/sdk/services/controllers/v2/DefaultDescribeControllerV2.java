package com.manywho.sdk.services.controllers.v2;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.services.describe.DescribeManagerV2;

@Path("/metadata")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DefaultDescribeControllerV2 {
    private final DescribeManagerV2 describeManager;

    @Inject
    public DefaultDescribeControllerV2(DescribeManagerV2 describeManager) {
        this.describeManager = describeManager;
    }

    @POST
    public DescribeServiceResponse describe() {
        return describeManager.describe();
    }
}
