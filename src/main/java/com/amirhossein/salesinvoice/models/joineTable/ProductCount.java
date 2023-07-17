package com.amirhossein.salesinvoice.models.joineTable;

import com.amirhossein.salesinvoice.models.compositeKey.ProductCountKey;
import com.amirhossein.salesinvoice.models.invoice.Invoice;
import com.amirhossein.salesinvoice.models.product.Product;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product_count")
@Data
public class ProductCount {

    @EmbeddedId
    private ProductCountKey compositeKey;

    @ManyToOne
    @MapsId("invoiceId")
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer count;
}
