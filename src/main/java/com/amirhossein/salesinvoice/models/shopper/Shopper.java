package com.amirhossein.salesinvoice.models.shopper;

import com.amirhossein.salesinvoice.models.audit.AuditModel;
import com.amirhossein.salesinvoice.models.invoice.Invoice;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shoppers")
@Data
public class Shopper extends AuditModel {

    private String name;

    private String address;

    private String phoneNumber;
}
