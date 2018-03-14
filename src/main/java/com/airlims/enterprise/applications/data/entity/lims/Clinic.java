package com.airlims.enterprise.applications.data.entity.lims;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import javax.persistence.*;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clinic")
@Entity(name="clinic")
public class Clinic extends BaseEntity {

    @JsonView(DataTablesOutput.View.class)
    @JsonProperty("name")
    @Column(name="name")
    private String name;

    @JsonView(DataTablesOutput.View.class)
    @JsonProperty("contact_info")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contact_info_id")
    private ContactInfo contactInfo;

}
