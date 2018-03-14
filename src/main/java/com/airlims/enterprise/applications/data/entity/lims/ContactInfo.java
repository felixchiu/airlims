package com.airlims.enterprise.applications.data.entity.lims;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="contact_info")
@Entity(name="contactInfo")
public class ContactInfo extends BaseEntity {

    @Column(name="primary_contact")
    private String primaryContact;

    @Column(name="street_1")
    private String street1;

    @Column(name="street_2")
    private String street2;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="post_code")
    private String postCode;

    @Column(name="country")
    private String country;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="secondary_phone_number")
    private String secondaryPhoneNumber;

    @Column(name="fax")
    private String fax;

    @Column(name="email")
    private String email;

    @Column(name="office_hours")
    private String officeHours;

    @Column(name="receive_email")
    private Boolean receiveEmail;

    @Column(name="support_contact")
    private String supportContact;

    @Column(name="support_phone_number")
    private String supportPhoneNumber;

    @Column(name="support_email")
    private String supportEmail;

    @Column(name="billing_contact")
    private String billingContact;

    @Column(name="billing_phone_number")
    private String billingPhoneNumber;

    @Column(name="billing_email")
    private String billingEmail;

}
