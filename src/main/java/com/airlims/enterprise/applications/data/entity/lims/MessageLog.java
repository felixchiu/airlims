package com.airlims.enterprise.applications.data.entity.lims;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Felix Chiu on 5/12/17.
 */
@Data
@Entity(name = "messageLog")
@Table(name = "message_log",
        indexes = {@Index(name = "message_log_message_id",  columnList="message_id"),
                @Index(name = "message_log_message_type", columnList="message_type")})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageLog {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "message_id")
    private String messageId;

    @Column(name = "action")
    private String action;

    @Column(name = "log_datetime")
    private Date logDatetime;

    @Column(name = "message_type")
    private String messageType;

    @Column(name = "message")
    private String message;

}
