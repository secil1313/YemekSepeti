package com.secil.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblcustomer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//idyi otomatik arttırıyordu.
    private Integer customer_id;
    @NotBlank
    private String customer_name;
    private String surname;
    @Email
    private String email;
    @NotBlank
    private String address;
    private int phoneNumber;

    private String password;
    @NotBlank
    private String cardDetails;
    private String balance;
    private String activationCode;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status=EStatus.PENDING;


}
