package com.amirhossein.salesinvoice.converters.joinTable;

import com.amirhossein.salesinvoice.models.joineTable.ProductCount;
import com.amirhossein.salesinvoice.models.joineTable.ProductCountRes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductCountToRes implements Converter<ProductCount , ProductCountRes> {

    @Override
    public ProductCountRes convert(ProductCount input) {

        ProductCountRes output = new ProductCountRes();

        output.setId(input.getId());
        output.setInvoice(input.getInvoice());
        output.setProduct(input.getProduct());
        output.setCount(input.getCount());

        return output;
    }
}
