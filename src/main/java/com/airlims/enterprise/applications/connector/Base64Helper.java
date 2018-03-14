package com.airlims.enterprise.applications.connector;

import org.springframework.stereotype.Component;

import java.util.Base64;

/**
 * Created by Felix Chiu on 10/27/16.
 */
@Component
public class Base64Helper {

    public String decode(String input){

        if (input != null ){
            byte[] decodedBytes = Base64.getDecoder().decode(input);
            return new String(decodedBytes);
        }

        return null;
    }


    public String encode(String input){

        if (input != null ){
            byte[] decodedBytes = Base64.getEncoder().encode(input.getBytes());
            return new String(decodedBytes);
        }

        return null;
    }
}
