package com.airlims.enterprise.applications.config;


import com.airlims.enterprise.applications.util.TokenGenerator;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Configuration
public class AppConfig {

    @Bean
    public TokenGenerator tokenGenerator() {
        return new TokenGenerator(10);
    }

    @Bean
    public Mapper beanMapper() {
        return new DozerBeanMapper();
    }
}
