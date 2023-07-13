package com.amirhossein.salesinvoice.models.invoice;

import com.amirhossein.salesinvoice.models.audit.AuditModelRes;
import com.amirhossein.salesinvoice.models.product.Product;
import com.amirhossein.salesinvoice.models.product.ProductRes;
import com.amirhossein.salesinvoice.models.seller.SellerRes;
import com.amirhossein.salesinvoice.models.shopper.ShopperRes;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class InvoiceRes extends AuditModelRes {

    private Date date;

    private Long invoiceNum;

    private SellerRes seller;

    private ShopperRes shopper;

    List<ProductRes> products = new ArrayList<>();
}
