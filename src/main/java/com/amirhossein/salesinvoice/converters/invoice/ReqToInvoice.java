package com.amirhossein.salesinvoice.converters.invoice;

import com.amirhossein.salesinvoice.converters.product.ReqToProduct;
import com.amirhossein.salesinvoice.converters.seller.ReqToSeller;
import com.amirhossein.salesinvoice.converters.shopper.ReqToShopper;
import com.amirhossein.salesinvoice.models.invoice.Invoice;
import com.amirhossein.salesinvoice.models.invoice.InvoiceReq;
import com.amirhossein.salesinvoice.models.seller.Seller;
import com.amirhossein.salesinvoice.models.shopper.Shopper;
import com.amirhossein.salesinvoice.repositories.ProductRepository;
import com.amirhossein.salesinvoice.repositories.SellerRepository;
import com.amirhossein.salesinvoice.repositories.ShopperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReqToInvoice implements Converter<InvoiceReq, Invoice> {

    private ReqToProduct reqToProduct;
    private ReqToSeller reqToSeller;
    private ReqToShopper reqToShopper;
    private ProductRepository productRepository;
    private SellerRepository sellerRepository;
    private ShopperRepository shopperRepository;

    @Autowired
    public ReqToInvoice(ReqToProduct reqToProduct, ReqToSeller reqToSeller, ReqToShopper reqToShopper, ProductRepository productRepository, SellerRepository sellerRepository, ShopperRepository shopperRepository) {
        this.reqToProduct = reqToProduct;
        this.reqToSeller = reqToSeller;
        this.reqToShopper = reqToShopper;
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.shopperRepository = shopperRepository;
    }

    @Override
    public Invoice convert(InvoiceReq input) {

        Invoice output = new Invoice();

        output.setDate(input.getDate());
        output.setInvoiceNum(input.getInvoiceNum());


        for (int i = 0; i < input.getProductReqs().size(); i++) {
            output.getProducts().add(productRepository.save(reqToProduct.convert(input.getProductReqs().get(i))));
        }

        output.setSeller(sellerRepository.save(reqToSeller.convert(input.getSellerReq())));
        output.setShopper(shopperRepository.save(reqToShopper.convert(input.getShopperReq())));

        return output;
    }
}
