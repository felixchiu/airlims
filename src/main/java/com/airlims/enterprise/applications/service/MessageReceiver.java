package com.airlims.enterprise.applications.service;

import com.airlims.enterprise.applications.data.dto.InternalMessage;
import com.airlims.enterprise.applications.data.service.MessageLogDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Slf4j
@Service
public class MessageReceiver {


    @Autowired
    private MessageLogDataService messageLogDataService;

    private final static ObjectMapper mapper = new ObjectMapper();

    public void receiveMessage(String message) {
        log.info(message);
        try {
            InternalMessage internalMessage = mapper.readValue(message, InternalMessage.class);
            if (internalMessage == null) {
                log.error("[NOTIFY SUPPORT] Message error: {}", message);
                return;
            }
            messageLogDataService.receiveLog(internalMessage.getId(), internalMessage.getLogDatetime(), internalMessage.getMessageType().toString(), message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
