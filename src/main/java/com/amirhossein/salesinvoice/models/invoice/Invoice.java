package com.amirhossein.salesinvoice.models.invoice;

import com.amirhossein.salesinvoice.models.audit.AuditModel;
import com.amirhossein.salesinvoice.models.joineTable.ProductCount;
import com.amirhossein.salesinvoice.models.seller.Seller;
import com.amirhossein.salesinvoice.models.shopper.Shopper;
import lombok.Data;

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
    private String number;

    @OneToOne()
    private Seller seller;

    @OneToOne()
    private Shopper shopper;

    @OneToMany(mappedBy = "invoice")
    private List<ProductCount> counts = new ArrayList<>();
}
