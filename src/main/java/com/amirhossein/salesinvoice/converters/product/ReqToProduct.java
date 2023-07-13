package com.amirhossein.salesinvoice.converters.product;

import com.amirhossein.salesinvoice.models.product.Product;
import com.amirhossein.salesinvoice.models.product.ProductReq;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReqToProduct implements Converter<ProductReq, Product> {

    @Override
    public Product convert(ProductReq input) {

        Product output = new Product();

        output.setName(input.getName());
        output.setPrice(input.getPrice());
        output.setTotalPrice(input.getTotalPrice());

        return output;
    }
}
