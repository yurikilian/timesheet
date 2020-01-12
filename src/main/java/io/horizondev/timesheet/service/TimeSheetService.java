package io.horizondev.timesheet.service;

import io.horizondev.timesheet.domain.entity.TimeRegistryEntity;
import io.horizondev.timesheet.domain.model.TimeRegistry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Validator;

import java.time.LocalDateTime;

@ApplicationScoped
public class TimeSheetService {



    @Inject
    Validator validator;

    public TimeRegistry get() {
        final TimeRegistryEntity entity = new TimeRegistryEntity();
        entity.setStartDate(LocalDateTime.now());
        entity.setEndDate(LocalDateTime.now());
        return new TimeRegistry(entity);
    }

    @Transactional
    public TimeRegistry create(TimeRegistry registry) {
        final TimeRegistryEntity entity = new TimeRegistryEntity();
        entity.setDescription(registry.getDescription());
        entity.setStartDate(registry.getStartDate());
        entity.setEndDate(registry.getEndDate());
        entity.persist();
        
        return new TimeRegistry(entity);
    }

}
