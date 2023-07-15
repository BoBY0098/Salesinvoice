package com.amirhossein.salesinvoice.models.user;

import com.amirhossein.salesinvoice.models.audit.AuditModelRes;
import lombok.Data;

@Data
public class UserRes extends AuditModelRes {

    private String userName;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String token;

    private String refreshToken;
}
