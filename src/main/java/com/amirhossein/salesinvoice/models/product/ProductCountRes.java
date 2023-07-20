package com.amirhossein.salesinvoice.models.product;

import lombok.Data;

@Data
public class ProductCountRes {

    private ProductRes product;
    private Integer count;
}
