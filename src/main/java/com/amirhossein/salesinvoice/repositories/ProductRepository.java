package com.amirhossein.salesinvoice.repositories;

import com.amirhossein.salesinvoice.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product , UUID> {

}
