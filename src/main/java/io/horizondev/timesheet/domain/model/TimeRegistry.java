package io.horizondev.timesheet.domain.model;


import io.horizondev.timesheet.domain.entity.TimeRegistryEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RegisterForReflection
public class TimeRegistry {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public TimeRegistry() {
    }

    public TimeRegistry(TimeRegistryEntity entity) {
        startDate = entity.getStartDate();
        endDate = entity.getEndDate();
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
