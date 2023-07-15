package com.amirhossein.salesinvoice.services.service;

import com.amirhossein.salesinvoice.models.product.ProductReq;
import com.amirhossein.salesinvoice.models.product.ProductRes;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductRes> getAllProducts();

    ProductRes getProductById(UUID productId);

    ProductRes createProduct(ProductReq productReq);
}
