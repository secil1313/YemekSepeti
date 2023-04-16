package com.secil.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {

    @NotBlank
    private String customer_name;
    @Email
    private String email;
    @NotBlank
    private String address;

    private String password;
    private String repassword;
    @NotBlank
    private String cardDetails;

}
