package com.airlims.enterprise.applications.data.entity.lims;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="family")
@Entity(name="family")
public class Family extends BaseEntity {

    @Column(name="name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id")
    private Subject patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="partner_id")
    private Subject partner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="egg_donor_id")
    private Subject eggDonor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sperm_donor_id")
    private Subject spermDonor;
}
