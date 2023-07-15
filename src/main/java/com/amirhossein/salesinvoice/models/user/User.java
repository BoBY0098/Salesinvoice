package com.amirhossein.salesinvoice.models.user;

import com.amirhossein.salesinvoice.models.audit.AuditModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class User extends AuditModel {

    @Column(unique = true , nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;
}
