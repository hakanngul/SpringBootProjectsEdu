package com.hakangul.handler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiError<T> {

    private Integer status;
    private Exception<T> exception;
}
