package com.amirhossein.salesinvoice.models.user;

import lombok.Data;

@Data
public class UserReq {

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;
}
