package com.airlims.enterprise.applications.service;

import com.airlims.enterprise.applications.data.service.AuditLogDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Felix Chiu on 11/16/17.
 */
@Service
public class AuditLogService {

    @Autowired
    private AuditLogDataService dataService;

    @Async("auditLogExecutor")
    public void addAuditLog(String authorizationId, String userId, String entityName, String fieldName, String oldValue, String newValue) {
        if (!StringUtils.equals(oldValue, newValue)) {
            dataService.addAuditLog(authorizationId, userId, entityName, fieldName, oldValue, newValue);
        }
    }

}
