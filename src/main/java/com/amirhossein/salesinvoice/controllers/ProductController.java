package com.amirhossein.salesinvoice.controllers;

import com.amirhossein.salesinvoice.models.product.ProductReq;
import com.amirhossein.salesinvoice.models.product.ProductRes;
import com.amirhossein.salesinvoice.services.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = "products")
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    @ApiOperation(value = "Get all Products" , notes = "Get all Products" , response = ProductRes.class ,responseContainer = "List" , authorizations = {@Authorization(value = "jwtToken")})
    public List<ProductRes> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    @ApiOperation(value = "Get a Product" , notes = "Get a Product by ProductID" , response = ProductRes.class , authorizations = {@Authorization(value = "jwtToken")})
    public ProductRes getProductById(@PathVariable UUID productId){
        return productService.getProductById(productId);
    }

    @PostMapping()
    @ApiOperation(value = "Create a New Product" , notes = "Create a New Product" , response = ProductRes.class , authorizations = {@Authorization(value = "jwtToken")})
    public ProductRes createProduct(@RequestBody ProductReq productReq){
        return productService.createProduct(productReq);
    }
}
