package com.amirhossein.salesinvoice.models.user;

import com.amirhossein.salesinvoice.models.audit.AuditModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class User extends AuditModel {

    private String userName;

    private String firstName;

    private String phoneNumber;
}
