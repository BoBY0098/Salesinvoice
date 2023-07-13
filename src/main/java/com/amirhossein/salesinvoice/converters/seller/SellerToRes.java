package com.amirhossein.salesinvoice.converters.seller;

import com.amirhossein.salesinvoice.models.seller.Seller;
import com.amirhossein.salesinvoice.models.seller.SellerRes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SellerToRes implements Converter<Seller , SellerRes> {

    @Override
    public SellerRes convert(Seller input) {

        SellerRes output = new SellerRes();

        output.setId(input.getId());

        output.setCompanyName(input.getCompanyName());
        output.setPhoneNumber(input.getPhoneNumber());

        return output;
    }
}
