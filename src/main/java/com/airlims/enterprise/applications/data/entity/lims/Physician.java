package com.airlims.enterprise.applications.data.entity.lims;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="physician")
@Entity(name="physician")
public class Physician extends BaseEntity {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="npi_number")
    private String npiNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contact_info_id")
    private ContactInfo contactInfo;
}
