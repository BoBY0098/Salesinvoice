package com.amirhossein.salesinvoice.converters.shopper;

import com.amirhossein.salesinvoice.models.shopper.Shopper;
import com.amirhossein.salesinvoice.models.shopper.ShopperReq;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReqToShopper implements Converter<ShopperReq , Shopper> {

    @Override
    public Shopper convert(ShopperReq input) {

        Shopper output = new Shopper();

        output.setCompanyName(input.getCompanyName());
        output.setPhoneNumber(input.getPhoneNumber());

        return output;
    }
}
