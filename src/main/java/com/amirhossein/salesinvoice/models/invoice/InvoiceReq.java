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
import java.util.UUID;

@Data
public class InvoiceReq {

    private Date date;

    private UUID sellerId;

    private UUID shopperId;

    private UUID productId;

    private Boolean generateNum;

    List<ProductReq> productReqs = new ArrayList<>();
}
