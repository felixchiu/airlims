package com.airlims.enterprise.applications.data.entity.lims;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.jdo.annotations.Join;
import javax.persistence.*;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="case_file")
@Entity(name="caseFile")
public class CaseFile extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="family_id")
    private Family family;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="test_type_id")
    private TestType testType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="clinic_id")
    private Clinic clinic;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="physician_id")
    private Physician physician;


}
