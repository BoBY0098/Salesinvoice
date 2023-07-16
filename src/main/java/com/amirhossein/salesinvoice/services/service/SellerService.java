package com.amirhossein.salesinvoice.services.service;

import com.amirhossein.salesinvoice.models.seller.SellerReq;
import com.amirhossein.salesinvoice.models.seller.SellerRes;

import java.util.List;
import java.util.UUID;

public interface SellerService {

    List<SellerRes> getAll();

    SellerRes getById(UUID sellerId);

    SellerRes createSeller(SellerReq sellerReq);
}
