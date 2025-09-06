package com.hakangul.controller.impl;


import com.hakangul.model.RootEntity;

public class RestBaseController {

    public <T> RootEntity<T> ok (T data) {
        return RootEntity.ok(data);
    }

    public <T> RootEntity<T> error (String errorMessage) {
        return RootEntity.error(errorMessage);
    }
}
