package com.airlims.enterprise.applications.data.entity.lims;

/**
 * Created by Felix Chiu on 11/11/17.
 */
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.util.Date;

public class EntityListener {
    @PrePersist
    public void prePersist(BaseEntity entity) {
        entity.setCreatedDatetime(new Timestamp(new Date().getTime()));
    }

    @PreUpdate
    public void preUpdate(BaseEntity entity) {
        entity.setUpdatedDatetime(new Timestamp(new Date().getTime()));
    }
}
