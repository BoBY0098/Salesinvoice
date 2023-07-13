package com.amirhossein.salesinvoice.models.seller;

import com.amirhossein.salesinvoice.models.audit.AuditModelRes;
import lombok.Data;

@Data
public class SellerRes extends AuditModelRes {

    private String companyName;

    private String phoneNumber;
}
