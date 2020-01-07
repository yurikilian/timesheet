package io.horizondev.timesheet.service;

import io.horizondev.timesheet.domain.entity.TimeRegistryEntity;
import io.horizondev.timesheet.domain.model.TimeRegistry;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApplicationScoped
public class TimeSheetService {

    @Transactional
    public TimeRegistry create() {

        final TimeRegistryEntity entity = new TimeRegistryEntity();
        entity.setStartDate(LocalDateTime.now());
        entity.setEndDate(LocalDateTime.now());
        entity.persist();

        return new TimeRegistry(entity);
    }

}
