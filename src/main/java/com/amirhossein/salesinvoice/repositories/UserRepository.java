package com.amirhossein.salesinvoice.repositories;

import com.amirhossein.salesinvoice.models.seller.Seller;
import com.amirhossein.salesinvoice.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
        Optional<User> findByVerifiedIsTrueAndUserName(String username);
}
