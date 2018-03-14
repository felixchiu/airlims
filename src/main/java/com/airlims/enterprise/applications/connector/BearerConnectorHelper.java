package com.airlims.enterprise.applications.connector;

/**
 * Created by Felix Chiu on 10/31/16.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;

@Slf4j
@Service
public class BearerConnectorHelper {

    @Value("${external.api.auth.url:localhost}")
    private String authUrl;

    private String token;

    private RestTemplate restTemplate = new RestTemplate();

    public String generateToken(String url, String userName, String password, boolean force) {
        log.debug("Reviewing the token");
        if (token==null || force) {
            log.debug("Token is not available OR it is a force regenerate. Generating the token.");
            HttpEntity<BearerLogin> response = restTemplate.exchange(url, HttpMethod.POST, ConnectorHelper.getHttpEntity(userName, password), BearerLogin.class);
            if (response != null && response.getBody() != null) {
                token = response.getBody().getEncoded();
                log.debug("Token is generated: " + token);
            } else {
                log.error("Error while generating token");
            }
        }
        return token;
    }

    public HttpEntity getHttpEntity(String userName, String password) {
        token = generateToken(authUrl, userName, password, false);
        return new HttpEntity(generateHeaders(false));
    }


    public <T> HttpEntity<T> getHttpEntity(T body, String userName, String password) {
        token = generateToken(authUrl, userName, password, false);
        return new HttpEntity(body, generateHeaders(false));
    }


    private HttpHeaders generateHeaders(boolean hasContent) {
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        if (hasContent) {
            headers.setContentType(MediaType.APPLICATION_JSON);
        }
        return headers;
    }



}