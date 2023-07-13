package com.amirhossein.salesinvoice.repositories;

import com.amirhossein.salesinvoice.models.shopper.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShopperRepository extends JpaRepository<Shopper , UUID> {

}
