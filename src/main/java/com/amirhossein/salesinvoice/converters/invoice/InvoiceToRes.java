package com.amirhossein.salesinvoice.converters.invoice;

import com.amirhossein.salesinvoice.converters.product.ProductToRes;
import com.amirhossein.salesinvoice.converters.seller.SellerToRes;
import com.amirhossein.salesinvoice.converters.shopper.ShopperToRes;
import com.amirhossein.salesinvoice.models.invoice.Invoice;
import com.amirhossein.salesinvoice.models.invoice.InvoiceRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InvoiceToRes implements Converter<Invoice, InvoiceRes> {

    private ProductToRes productToRes;
    private SellerToRes sellerToRes;
    private ShopperToRes shopperToRes;

    @Autowired
    public InvoiceToRes(ProductToRes productToRes, SellerToRes sellerToRes, ShopperToRes shopperToRes) {
        this.productToRes = productToRes;
        this.sellerToRes = sellerToRes;
        this.shopperToRes = shopperToRes;
    }

    @Override
    public InvoiceRes convert(Invoice input) {

        InvoiceRes output = new InvoiceRes();

        output.setId(input.getId());

        output.setDate(input.getDate());
        output.setInvoiceNum(input.getInvoiceNum());

        for (int i = 0; i < input.getCounts().size(); i++) {
            output.getCounts().add(input.getCounts().get(i));
        }

        output.setSeller(sellerToRes.convert(input.getSeller()));
        output.setShopper(shopperToRes.convert(input.getShopper()));

        return output;
    }
}
