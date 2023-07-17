package com.amirhossein.salesinvoice.models.compositeKey;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
public class ProductCountKey implements Serializable {

    @Column(name = "invoice_id")
    private UUID invoiceId;

    @Column(name = "product_id")
    private UUID productId;
}
