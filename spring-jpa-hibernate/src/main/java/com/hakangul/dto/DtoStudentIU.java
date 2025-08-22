package com.hakangul.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "FirstName alanı boş bırakılamaz")
    @Min(value = 3, message = "En az 3 karakter olmalıdır")
    @Max(value = 10, message = "En fazla 10 karakter olmalıdır")
    private String firstName;

    @Size(min = 3, max = 20, message = "En az 3 en fazla 20 karakter olmalıdır")
    @NotEmpty(message = "LastName alanı boş bırakılamaz")
    private String lastName;


    private Date birthOfDate;

    @Email(message = "Email formatında olmalıdır")
    private String email;

    @Size(min = 11, max = 11, message = "TCKN 11 haneli olmalıdır")
    @NotEmpty(message = "TCKN alanı boş bırakılamaz")
    private String tckn;
}
