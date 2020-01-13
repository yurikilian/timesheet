package io.horizondev.timesheet.domain.exception;

public class TimeRegistryInvalidDateException extends AbstractBusinessException {
    private static final long serialVersionUID = 1L;

    public TimeRegistryInvalidDateException(String message) {
        super(message);
    }

}