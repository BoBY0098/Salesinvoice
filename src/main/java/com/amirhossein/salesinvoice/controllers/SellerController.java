package com.amirhossein.salesinvoice.controllers;

import com.amirhossein.salesinvoice.models.seller.SellerReq;
import com.amirhossein.salesinvoice.models.seller.SellerRes;
import com.amirhossein.salesinvoice.services.service.SellerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = "sellers")
@RequestMapping("/sellers")
public class SellerController {

    private SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping()
    @ApiOperation(value = "Read all Sellers" , notes = "Read all Sellers" , response = SellerRes.class , responseContainer = "List")
    public List<SellerRes> getAll(){
        return sellerService.getAll();
    }

    @GetMapping("/{sellerId}")
    @ApiOperation(value = "Read a Seller" , notes = "Read a Seller by sellerId" , response = SellerRes.class)
    public SellerRes getById(@PathVariable UUID sellerId){
        return sellerService.getById(sellerId);
    }

    @PostMapping
    @ApiOperation(value = "Create new Seller" , notes = "Create new Seller" , response = SellerRes.class)
    public SellerRes createSeller(@RequestBody SellerReq sellerReq){
        return sellerService.createSeller(sellerReq);
    }

}
