package com.airlims.enterprise.applications.data.repository.lims;

import com.airlims.enterprise.applications.data.entity.lims.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, String> {
}
