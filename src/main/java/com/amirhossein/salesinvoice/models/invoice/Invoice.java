package com.amirhossein.salesinvoice.models.invoice;

import com.amirhossein.salesinvoice.models.audit.AuditModel;
import com.amirhossein.salesinvoice.models.product.Product;
import com.amirhossein.salesinvoice.models.seller.Seller;
import com.amirhossein.salesinvoice.models.shopper.Shopper;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
@Data
public class Invoice extends AuditModel {

    private Date date;

    @Column(length = 6)
    private String invoiceNum;

    @OneToOne()
    private Seller seller;

    @OneToOne()
    private Shopper shopper;

    @OneToMany()
    List<Product> products = new ArrayList<>();
}
