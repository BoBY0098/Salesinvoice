package com.amirhossein.salesinvoice.services.impl;

import com.amirhossein.salesinvoice.converters.product.ProductToRes;
import com.amirhossein.salesinvoice.converters.product.ReqToProduct;
import com.amirhossein.salesinvoice.models.product.Product;
import com.amirhossein.salesinvoice.models.product.ProductReq;
import com.amirhossein.salesinvoice.models.product.ProductRes;
import com.amirhossein.salesinvoice.repositories.ProductRepository;
import com.amirhossein.salesinvoice.services.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductToRes productToRes;
    private ReqToProduct reqToProduct;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductToRes productToRes, ReqToProduct reqToProduct) {
        this.productRepository = productRepository;
        this.productToRes = productToRes;
        this.reqToProduct = reqToProduct;
    }

    @Override
    public List<ProductRes> getAllProducts() {

        List<Product> products = productRepository.findAll();

        List<ProductRes> res = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            res.add(productToRes.convert(products.get(i)));
        }
        return res;
    }

    @Override
    public ProductRes getProductById(UUID productId) {

        Optional<Product> product = productRepository.findById(productId);
        ProductRes res = productToRes.convert(product.get());

        return res;
    }

    @Override
    public ProductRes createProduct(ProductReq productReq) {

        Product product = reqToProduct.convert(productReq);
        productRepository.save(product);
        ProductRes res = productToRes.convert(product);

        return res;
    }
}
