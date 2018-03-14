package com.airlims.enterprise.applications.data.entity.lims;

/**
 * Created by Felix Chiu on 11/11/17.
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
@EntityListeners(EntityListener.class)
@Data
public class BaseEntity implements Serializable {

    @JsonView(DataTablesOutput.View.class)
    @JsonProperty("id")
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(generator = "token-uuid")
    @GenericGenerator(name = "token-uuid", strategy = "com.airlims.enterprise.applications.util.InquisitiveUUIDGenerator")
    private String id;

    @JsonProperty("updated_datetime")
    @Column(name="updated_datetime")
    @JsonFormat(shape= JsonFormat.Shape.STRING)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @JsonView(DataTablesOutput.View.class)
    private Timestamp updatedDatetime;

    @JsonProperty("updated_by")
    @Column(name="updated_by")
    @JsonView(DataTablesOutput.View.class)
    private String updatedBy;

    @NotNull
    @JsonProperty("created_datetime")
    @Column(name="created_datetime", updatable = false)
    @JsonFormat(shape= JsonFormat.Shape.STRING)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @JsonView(DataTablesOutput.View.class)
    private Timestamp createdDatetime;

    @NotBlank
    @JsonProperty("created_by")
    @Column(name="created_by", updatable = false)
    @JsonView(DataTablesOutput.View.class)
    private String createdBy;

    @JsonProperty("active_record_indicator")
    @Column(name = "active_record_indicator")
    @JsonView(DataTablesOutput.View.class)
    private boolean activeRecord = true;

    @Version
    @JsonProperty("version")
    @Column(name = "version")
    private Integer version;

    @JsonProperty("source_system")
    @JoinColumn(name = "source_system_id", nullable = false)
    @JsonView(DataTablesOutput.View.class)
    @ManyToOne(cascade = CascadeType.ALL)
    private SourceSystem sourceSystem;

    @JsonProperty("source_id")
    @Column(name = "source_id")
    @JsonView(DataTablesOutput.View.class)
    private String sourceId;



}
