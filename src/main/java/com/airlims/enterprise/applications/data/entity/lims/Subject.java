package com.airlims.enterprise.applications.data.entity.lims;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subject")
@Entity(name="subject")
public class Subject extends BaseEntity {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Temporal(value = TemporalType.DATE)
    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="gender")
    private String gender;

    @Column(name="has_single_name")
    private Boolean hasSingleName = false;

    @Column(name="third_party_patient_id")
    private String thirdPartyPatientId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contact_info_id")
    private ContactInfo contactInfo;

}
