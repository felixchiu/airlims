package com.airlims.enterprise.applications.data.repository.lims;

import com.airlims.enterprise.applications.data.entity.lims.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Felix Chiu on 11/16/17.
 */
@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findByEntityId(String entityId);
}
