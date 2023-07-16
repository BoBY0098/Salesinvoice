package com.amirhossein.salesinvoice.converters.shopper;

import com.amirhossein.salesinvoice.models.shopper.Shopper;
import com.amirhossein.salesinvoice.models.shopper.ShopperRes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ShopperToRes implements Converter<Shopper , ShopperRes> {

    @Override
    public ShopperRes convert(Shopper input) {

        ShopperRes output = new ShopperRes();

        output.setId(input.getId());

        output.setCompanyName(input.getCompanyName());
        output.setPhoneNumber(input.getPhoneNumber());

        return output;
    }
}
