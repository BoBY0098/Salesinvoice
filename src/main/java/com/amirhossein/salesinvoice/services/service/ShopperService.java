package com.amirhossein.salesinvoice.services.service;

import com.amirhossein.salesinvoice.models.seller.SellerReq;
import com.amirhossein.salesinvoice.models.seller.SellerRes;
import com.amirhossein.salesinvoice.models.shopper.ShopperReq;
import com.amirhossein.salesinvoice.models.shopper.ShopperRes;

import java.util.List;
import java.util.UUID;

public interface ShopperService {

    List<ShopperRes> getAll();

    ShopperRes getById(UUID shopperId);

    ShopperRes createSeller(ShopperReq shopperReq);
}
