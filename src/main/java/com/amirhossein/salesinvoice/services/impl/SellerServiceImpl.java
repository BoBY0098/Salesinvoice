package com.amirhossein.salesinvoice.services.impl;

import com.amirhossein.salesinvoice.converters.seller.ReqToSeller;
import com.amirhossein.salesinvoice.converters.seller.SellerToRes;
import com.amirhossein.salesinvoice.models.seller.Seller;
import com.amirhossein.salesinvoice.models.seller.SellerReq;
import com.amirhossein.salesinvoice.models.seller.SellerRes;
import com.amirhossein.salesinvoice.repositories.SellerRepository;
import com.amirhossein.salesinvoice.services.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SellerServiceImpl implements SellerService {

    private ReqToSeller reqToSeller;
    private SellerToRes sellerToRes;
    private SellerRepository sellerRepository;

    @Autowired
    public SellerServiceImpl(ReqToSeller reqToSeller, SellerToRes sellerToRes, SellerRepository sellerRepository) {
        this.reqToSeller = reqToSeller;
        this.sellerToRes = sellerToRes;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public List<SellerRes> getAll() {
        List<Seller> sellers = sellerRepository.findAll();

        List<SellerRes> res = new ArrayList<>();

        for (int i = 0; i < sellers.size(); i++) {
            res.add(sellerToRes.convert(sellers.get(i)));
        }
        return res;
    }

    @Override
    public SellerRes getById(UUID sellerId) {

        Optional<Seller> seller = sellerRepository.findById(sellerId);

        SellerRes res = sellerToRes.convert(seller.get());

        return res;
    }

    @Override
    public SellerRes createSeller(SellerReq sellerReq) {

        Seller seller = reqToSeller.convert(sellerReq);

        sellerRepository.save(seller);

        SellerRes res = sellerToRes.convert(seller);

        return res;
    }
}
