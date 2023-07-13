package com.amirhossein.salesinvoice.repositories;

import com.amirhossein.salesinvoice.models.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice , UUID> {

}
