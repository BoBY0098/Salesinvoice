package com.amirhossein.salesinvoice.services.impl;

import com.amirhossein.salesinvoice.converters.shopper.ReqToShopper;
import com.amirhossein.salesinvoice.converters.shopper.ShopperToRes;
import com.amirhossein.salesinvoice.models.seller.SellerRes;
import com.amirhossein.salesinvoice.models.shopper.Shopper;
import com.amirhossein.salesinvoice.models.shopper.ShopperReq;
import com.amirhossein.salesinvoice.models.shopper.ShopperRes;
import com.amirhossein.salesinvoice.repositories.ShopperRepository;
import com.amirhossein.salesinvoice.services.service.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShopperServiceImpl implements ShopperService {

    private ShopperRepository shopperRepository;
    private ShopperToRes shopperToRes;
    private ReqToShopper reqToShopper;


    @Autowired
    public ShopperServiceImpl(ShopperRepository shopperRepository, ShopperToRes shopperToRes, ReqToShopper reqToShopper) {
        this.shopperRepository = shopperRepository;
        this.shopperToRes = shopperToRes;
        this.reqToShopper = reqToShopper;
    }

    @Override
    public List<ShopperRes> getAll() {

        List<Shopper> shoppers = shopperRepository.findAll();
        List<ShopperRes> res = new ArrayList<>();

        for (int i = 0; i < shoppers.size(); i++) {
            res.add(shopperToRes.convert(shoppers.get(i)));
        }

        return res;
    }

    @Override
    public ShopperRes getById(UUID shopperId) {

        Optional<Shopper> shopper = shopperRepository.findById(shopperId);

        ShopperRes res = shopperToRes.convert(shopper.get());

        return res;
    }

    @Override
    public ShopperRes createSeller(ShopperReq shopperReq) {

        Shopper shopper = reqToShopper.convert(shopperReq);

        shopperRepository.save(shopper);

        ShopperRes res = shopperToRes.convert(shopper);

        return res;
    }
}
