package io.horizondev.timesheet.domain.model;

import io.horizondev.timesheet.domain.entity.TimeRegistryEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RegisterForReflection
public class TimeRegistry {

    @NotBlank
    private String description;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;

    public TimeRegistry() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
