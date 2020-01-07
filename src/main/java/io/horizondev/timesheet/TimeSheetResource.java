package io.horizondev.timesheet;

import io.horizondev.timesheet.service.TimeSheetService;

import javax.inject.Inject;
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
        return Response.ok(timeSheetService.create()).build();
    }

    @POST
    public Response register() {
        return Response.noContent().build();
    }
}