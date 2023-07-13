package com.amirhossein.salesinvoice.converters.seller;

import com.amirhossein.salesinvoice.models.seller.Seller;
import com.amirhossein.salesinvoice.models.seller.SellerReq;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReqToSeller implements Converter<SellerReq , Seller> {

    @Override
    public Seller convert(SellerReq input) {

        Seller output = new Seller();

        output.setCompanyName(input.getCompanyName());
        output.setPhoneNumber(input.getPhoneNumber());

        return output;
    }
}
