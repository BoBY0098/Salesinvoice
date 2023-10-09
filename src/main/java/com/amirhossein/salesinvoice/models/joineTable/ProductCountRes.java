package com.amirhossein.salesinvoice.models.joineTable;

import com.amirhossein.salesinvoice.models.compositeKey.ProductCountKey;
import com.amirhossein.salesinvoice.models.invoice.Invoice;
import com.amirhossein.salesinvoice.models.product.Product;
import lombok.Data;

@Data
public class ProductCountRes {

    ProductCountKey id;

    Invoice invoice;

    Product product;

    Integer count;
}
