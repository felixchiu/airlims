package com.airlims.enterprise.applications.service;

import com.airlims.enterprise.applications.data.dto.InternalMessage;
import com.airlims.enterprise.applications.data.service.MessageLogDataService;
import com.airlims.enterprise.applications.util.TokenGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Felix Chiu on 2/15/18.
 */
@Slf4j
@Service
public class MessageSender {

    @Autowired
    private StringRedisTemplate template;

    @Value("${redis.config.queue:inter_service_queue}")
    private String queue;

    @Autowired
    private MessageLogDataService messageLogDataService;

    @Autowired
    private TokenGenerator tokenGenerator;

    private final static ObjectMapper mapper = new ObjectMapper();

    public void send(InternalMessage message) throws JsonProcessingException {
        message.setId(tokenGenerator.nextString());
        message.setLogDatetime(new Date());
        String messageBody = mapper.writeValueAsString(message);
        template.convertAndSend(queue, messageBody);
        messageLogDataService.sendLog(message.getId(), message.getLogDatetime(), message.getMessageType().toString(), messageBody);
    }


}
