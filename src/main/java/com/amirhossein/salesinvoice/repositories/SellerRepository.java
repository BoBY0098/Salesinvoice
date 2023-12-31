package com.amirhossein.salesinvoice.repositories;

import com.amirhossein.salesinvoice.models.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellerRepository extends JpaRepository<Seller , UUID> {

}
