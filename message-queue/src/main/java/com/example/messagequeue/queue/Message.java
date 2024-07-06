package com.example.messagequeue.queue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Message {

    private String id;
    private Object message;

}
