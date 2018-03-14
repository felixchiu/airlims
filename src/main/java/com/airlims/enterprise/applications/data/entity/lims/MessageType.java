package com.airlims.enterprise.applications.data.entity.lims;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Data
@Table(name="message_type")
@Entity(name="messageType")
public class MessageType {
    @Id
    @Column(name="id")
    private String id;

    @Column(name="description")
    private String description;
}
