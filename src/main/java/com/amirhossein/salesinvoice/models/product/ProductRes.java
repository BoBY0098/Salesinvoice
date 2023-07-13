package com.amirhossein.salesinvoice.models.product;

import com.amirhossein.salesinvoice.models.audit.AuditModelRes;
import lombok.Data;

@Data
public class ProductRes extends AuditModelRes {

    private String name;

    private Long price;

    private Long totalPrice;
}
