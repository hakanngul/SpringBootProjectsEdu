package com.hakangul.controller;

import com.hakangul.dto.DtoHome;

public interface IHomeController {

    public DtoHome findHomeById(Long id);
}
