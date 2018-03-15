package com.airlims.enterprise.applications.data.entity.lims;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="test_type")
@Entity(name="testType")
public class TestType {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="description")
    private String description;

}
