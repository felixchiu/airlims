package com.airlims.enterprise.applications.data.dto;

import com.airlims.enterprise.applications.data.entity.lims.MessageType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Felix Chiu on 2/15/18.
 * Note: This supposed to be an abstract class or interface.
 * However, we we need to handle the Jackson Mapper for identifying the corresponding to dispatch,
 * we need to have a real class for that.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternalMessage {

    private String id;

    @JsonFormat(shape= JsonFormat.Shape.STRING)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private Date logDatetime;

    private MessageType messageType;

}
