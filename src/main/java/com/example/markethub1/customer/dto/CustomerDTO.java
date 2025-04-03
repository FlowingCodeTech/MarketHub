package com.example.markethub1.customer.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String fullName;
    private String SNS;
    private String phoneNumber;
    private String email;
    private String job;
    private Date birthday;
    private String address;
    private String postalCode;
    private List myFavorites;


}
