package com.hakangul.handler;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Exception<T> {

    private String hostName;
    private String path;
    private Date createTime;
    private T message;
}
