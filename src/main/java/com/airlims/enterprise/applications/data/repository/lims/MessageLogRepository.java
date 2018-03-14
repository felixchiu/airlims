package com.airlims.enterprise.applications.data.repository.lims;

import com.airlims.enterprise.applications.data.entity.lims.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Felix Chiu on 5/12/17.
 */
@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, String> {
}
