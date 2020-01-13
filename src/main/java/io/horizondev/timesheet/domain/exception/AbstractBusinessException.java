package io.horizondev.timesheet.domain.exception;

public abstract class AbstractBusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AbstractBusinessException(String message) {
        super(message);
    }

}