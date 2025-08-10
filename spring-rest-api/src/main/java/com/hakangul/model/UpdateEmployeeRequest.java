package com.hakangul.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateEmployeeRequest {
    private String firstName;
    private String lastName;
}
