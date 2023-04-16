package com.secil.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateEmailOrPasswordRequestDto {
    private Integer customer_id;
    private String password;
    private String email;
    private String surname;
    private String balance;
}
