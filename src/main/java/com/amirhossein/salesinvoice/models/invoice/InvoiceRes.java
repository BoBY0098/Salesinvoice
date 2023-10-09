package com.amirhossein.salesinvoice.models.invoice;

import com.amirhossein.salesinvoice.models.audit.AuditModelRes;
import com.amirhossein.salesinvoice.models.joineTable.ProductCountRes;
import com.amirhossein.salesinvoice.models.seller.SellerRes;
import com.amirhossein.salesinvoice.models.shopper.ShopperRes;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class InvoiceRes extends AuditModelRes {

    private String number;
    private Date date;
    private SellerRes seller;
    private ShopperRes shopper;
    private List<ProductCountRes> products = new ArrayList<>();
}
