package com.amirhossein.salesinvoice.converters.product;

import com.amirhossein.salesinvoice.models.product.Product;
import com.amirhossein.salesinvoice.models.product.ProductRes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToRes implements Converter<Product , ProductRes> {

    @Override
    public ProductRes convert(Product input) {

        ProductRes output = new ProductRes();

        output.setId(input.getId());

        output.setName(input.getName());
        output.setPrice(input.getPrice());

        return output;
    }
}
