package com.hakangul.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    NO_RECORD_EXITS("1001", "Kayıt Bulunamadı"),    
    INVALID_PARAMETER("1002", "Geçersiz Parametre"),
    INVALID_REQUEST("1003", "Geçersiz İstek"),
    INTERNAL_SERVER_ERROR("1004", "Sunucu Hatası"),
    NOT_FOUND("1005", "Kayıt Bulunamadı"),
    UNAUTHORIZED("1006", "Yetkisiz İstek"),
    GENERAL_EXCEPTION("9999", "Genel Hata Oluştu");
    


    private String code;
    private String message;


    MessageType(String code, String messageString) {
        this.code = code;
        this.message = messageString;
    }

}
