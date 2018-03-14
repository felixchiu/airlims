package com.airlims.enterprise.applications.connector;

import lombok.Data;

/**
 * Created by Felix Chiu on 10/31/16.
 */
@Data
public class BearerLogin {

    private String claims;

    private String encoded;
}
