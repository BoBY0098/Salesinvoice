package com.amirhossein.salesinvoice.models.product;

import com.amirhossein.salesinvoice.models.audit.AuditModel;
import com.amirhossein.salesinvoice.models.invoice.Invoice;
import com.amirhossein.salesinvoice.models.joineTable.ProductCount;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product extends AuditModel {

    private String name;

    private Long price;

    @OneToMany(mappedBy = "product")
    List<ProductCount> counts;
}
