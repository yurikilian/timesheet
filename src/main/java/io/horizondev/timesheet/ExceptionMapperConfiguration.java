package io.horizondev.timesheet;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.horizondev.timesheet.domain.exception.AbstractBusinessException;

@Provider
public class ExceptionMapperConfiguration implements ExceptionMapper<AbstractBusinessException> {

    @Override
    public Response toResponse(AbstractBusinessException exception) {
        return Response.status(Status.BAD_REQUEST).build();
    }

}