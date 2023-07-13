package com.amirhossein.salesinvoice.models.product;

import com.amirhossein.salesinvoice.models.audit.AuditModel;
import com.amirhossein.salesinvoice.models.invoice.Invoice;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Data
public class Product extends AuditModel {

    private String name;

    private Long price;

    private Long totalPrice;

    @ManyToOne
    private Invoice invoice;
}
