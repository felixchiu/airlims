package com.airlims.enterprise.applications.config;

import com.airlims.enterprise.applications.service.MessageReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;


/**
 * Created by Felix Chiu on 3/14/18.
 */
@Slf4j
@Configuration
public class RedisConfig {

    @Value("${redis.config.host:redis}")
    private String host;

    @Value("${redis.config.port:6379}")
    private int port;

    @Value("${redis.config.queue:inter_service_queue}")
    private String queue;

    @Bean
    RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(port);
        factory.setUsePool(true);
        return factory;
    }

    @Bean
    RedisMessageListenerContainer container(MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory());
        container.addMessageListener(listenerAdapter, new PatternTopic(queue));
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    MessageReceiver receiver() {
        return new MessageReceiver();
    }

    @Bean
    StringRedisTemplate template() {
        log.info("Connect Factory: {}" , redisConnectionFactory());
        return new StringRedisTemplate(redisConnectionFactory());
    }

}
