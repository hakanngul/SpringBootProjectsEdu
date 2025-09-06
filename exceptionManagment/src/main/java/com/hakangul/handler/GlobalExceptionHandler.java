package com.hakangul.handler;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.hakangul.exception.BaseException;

@ControllerAdvice // Bu antasyon bütün exceptionları yakalamak için kullanılır
public class GlobalExceptionHandler {

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = { BaseException.class }) // Bu exception handler BaseException ile ilgili exceptionları
                                                       // yakalar
    public ResponseEntity<ApiError> handleBaseException(BaseException exception, WebRequest request) {
        return ResponseEntity.badRequest().body(createApiError(exception.getMessage(), request));
    }

    private String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("Bir Hata Oluştu " + e.getMessage());
        }
        return null;
    }

    public <T> ApiError<T> createApiError(T messageT, WebRequest request) {
        return ApiError.<T>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .exception(Exception.<T>builder()
                        .createTime(new Date())
                        .hostName(getHostName())
                        .path(request.getDescription(false).substring(4))
                        .message(messageT)
                        .build())
                .build();
    }

}
