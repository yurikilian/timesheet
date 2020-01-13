package io.horizondev.timesheet;

import io.horizondev.timesheet.domain.exception.TimeRegistryInvalidDateException;
import io.horizondev.timesheet.domain.model.TimeRegistry;
import io.horizondev.timesheet.service.TimeSheetService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/timesheet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeSheetResource {

    @Inject
    TimeSheetService timeSheetService;

    @GET
    public Response get() {

        throw new TimeRegistryInvalidDateException("Invalid Time");
        //return Response.ok(timeSheetService.get()).build();
    }

    @POST
    public Response register(@Valid final TimeRegistry registry) {
        return Response.ok(timeSheetService.create(registry)).build();
    }
}