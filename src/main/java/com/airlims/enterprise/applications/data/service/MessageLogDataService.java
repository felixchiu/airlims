package com.airlims.enterprise.applications.data.service;

import com.airlims.enterprise.applications.data.entity.lims.MessageLog;
import com.airlims.enterprise.applications.data.repository.lims.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Felix Chiu on 2/16/18.
 */
@Service
public class MessageLogDataService {

    @Autowired
    private MessageLogRepository repository;

    private final static String ACTION_SEND = "SEND";

    private final static String ACTION_RECEIVE = "RECEIVED";

    public void sendLog(String messageId, Date logDatetime, String messageType, String messageBody) {
        log(messageId, logDatetime, messageType, messageBody, ACTION_SEND);
    }


    public void receiveLog(String messageId, Date logDatetime, String messageType, String messageBody) {
        log(messageId, logDatetime, messageType, messageBody, ACTION_RECEIVE);
    }

    @Async("messageLogExecutor")
    public void log(String messageId, Date logDatetime, String messageType, String messageBody, String action) {
        repository.saveAndFlush(MessageLog.builder()
                .id(UUID.randomUUID().toString())
                .messageId(messageId)
                .action(action)
                .logDatetime(logDatetime)
                .messageType(messageType)
                .message(messageBody)
                .build());
    }
}
