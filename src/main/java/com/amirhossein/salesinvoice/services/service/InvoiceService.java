package com.amirhossein.salesinvoice.services.service;

import com.amirhossein.salesinvoice.models.invoice.InvoiceReq;
import com.amirhossein.salesinvoice.models.invoice.InvoiceRes;

import java.util.List;

public interface InvoiceService {

    List<InvoiceRes> getAllInvoices();

    InvoiceRes createInvoice(InvoiceReq invoiceReq);
}
