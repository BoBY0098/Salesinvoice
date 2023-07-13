package com.amirhossein.salesinvoice.models.seller;

import com.amirhossein.salesinvoice.models.audit.AuditModel;
import com.amirhossein.salesinvoice.models.invoice.Invoice;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sellers")
@Data
public class Seller extends AuditModel {

    private String companyName;

    private String phoneNumber;
}
