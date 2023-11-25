package com.example.order.domain.message;

import com.example.order.common.entity.BaseEntity;
import com.example.order.domain.message.enumtype.FailCode;
import com.example.order.domain.message.enumtype.MessageStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SendMessage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @Enumerated(EnumType.STRING)
    private MessageStatus status;
    @Enumerated(EnumType.STRING)
    private FailCode failCode;

    @Builder
    public SendMessage(String message, MessageStatus status, FailCode failCode) {
        this.message = message;
        this.status = status;
        this.failCode = failCode;
    }
}
