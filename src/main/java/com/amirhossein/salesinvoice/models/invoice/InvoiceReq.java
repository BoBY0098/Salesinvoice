package com.amirhossein.salesinvoice.models.invoice;

import com.amirhossein.salesinvoice.models.product.ProductReq;
import com.amirhossein.salesinvoice.models.seller.Seller;
import com.amirhossein.salesinvoice.models.seller.SellerReq;
import com.amirhossein.salesinvoice.models.shopper.Shopper;
import com.amirhossein.salesinvoice.models.shopper.ShopperReq;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class InvoiceReq {

    private Date date;

    private Long invoiceNum;

    private SellerReq sellerReq;

    private ShopperReq shopperReq;

    List<ProductReq> productReqs = new ArrayList<>();
}
