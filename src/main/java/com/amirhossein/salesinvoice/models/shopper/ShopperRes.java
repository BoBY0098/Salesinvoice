package com.amirhossein.salesinvoice.models.shopper;

import com.amirhossein.salesinvoice.models.audit.AuditModelRes;
import lombok.Data;

@Data
public class ShopperRes extends AuditModelRes {

    private String name;

    private String address;

    private String phoneNumber;
}
