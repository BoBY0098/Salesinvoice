package com.amirhossein.salesinvoice.controllers;

import com.amirhossein.salesinvoice.models.seller.SellerReq;
import com.amirhossein.salesinvoice.models.seller.SellerRes;
import com.amirhossein.salesinvoice.models.shopper.ShopperReq;
import com.amirhossein.salesinvoice.models.shopper.ShopperRes;
import com.amirhossein.salesinvoice.services.service.ShopperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = "shoppers")
@RequestMapping("/shoppers")
public class ShopperController {

    private ShopperService shopperService;

    @Autowired
    public ShopperController(ShopperService shopperService) {
        this.shopperService = shopperService;
    }

    @GetMapping()
    @ApiOperation(value = "Read all Shoppers" , notes = "Read all Shoppers" , response = ShopperRes.class , responseContainer = "List")
    public List<ShopperRes> getAll(){
        return shopperService.getAll();
    }

    @GetMapping("/{shopperId}")
    @ApiOperation(value = "Read a Shoppers" , notes = "Read a Seller by shopperId" , response = ShopperRes.class)
    public ShopperRes getById(@PathVariable UUID shopperId){
        return shopperService.getById(shopperId);
    }

    @PostMapping
    @ApiOperation(value = "Create new Shopper" , notes = "Create new Shopper" , response = ShopperRes.class)
    public ShopperRes createSeller(@RequestBody ShopperReq shopperReq){
        return shopperService.createSeller(shopperReq);
    }
}
