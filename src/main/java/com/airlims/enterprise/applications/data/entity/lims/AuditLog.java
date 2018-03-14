package com.airlims.enterprise.applications.data.entity.lims;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Felix Chiu on 11/16/17.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="audit_log", indexes = {
            @Index(name = "idx_audit_entity_id",  columnList="entity_id", unique = false),
            @Index(name = "idx_audit_field", columnList="entity_id, field_name", unique = false),
            @Index(name = "idx_audit_entity", columnList="entity_name", unique = false)
        }
        )
@Entity(name="auditLog")
public class AuditLog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="entity_id")
    private String entityId;

    @Column(name="user_id")
    private String userId;

    @Column(name="log_datetime")
    private Date logDatetime;

    @Column(name="entity_name")
    private String entityName;

    @Column(name="field_name")
    private String fieldName;

    @Lob
    @Column(name="old_value")
    private String oldValue;

    @Lob
    @Column(name="new_value")
    private String newValue;

}
