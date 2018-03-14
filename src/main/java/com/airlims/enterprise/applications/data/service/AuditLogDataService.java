package com.airlims.enterprise.applications.data.service;

import com.airlims.enterprise.applications.data.entity.lims.AuditLog;
import com.airlims.enterprise.applications.data.repository.lims.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Felix Chiu on 11/16/17.
 */
@Service
public class AuditLogDataService {

    @Autowired
    private AuditLogRepository repository;

    public void addAuditLog(String authorizationId, String userId, String entityName, String fieldName, String oldValue, String newValue) {
        repository.saveAndFlush(AuditLog.builder()
                .entityId(authorizationId)
                .userId(userId)
                .entityName(entityName)
                .fieldName(fieldName)
                .oldValue(oldValue)
                .newValue(newValue)
                .logDatetime(new Date())
                .build());
    }

    public List<AuditLog> retrieveAuditLogs(String entityId) {
        List<AuditLog> logs = repository.findByEntityId(entityId);
        return logs != null ? logs : new ArrayList<>();
    }
}
