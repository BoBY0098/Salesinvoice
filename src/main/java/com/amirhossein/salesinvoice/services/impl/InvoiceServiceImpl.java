package com.amirhossein.salesinvoice.services.impl;

import com.amirhossein.salesinvoice.converters.invoice.InvoiceToRes;
import com.amirhossein.salesinvoice.converters.invoice.ReqToInvoice;
import com.amirhossein.salesinvoice.models.invoice.Invoice;
import com.amirhossein.salesinvoice.models.invoice.InvoiceReq;
import com.amirhossein.salesinvoice.models.invoice.InvoiceRes;
import com.amirhossein.salesinvoice.repositories.InvoiceRepository;
import com.amirhossein.salesinvoice.repositories.ProductRepository;
import com.amirhossein.salesinvoice.repositories.SellerRepository;
import com.amirhossein.salesinvoice.repositories.ShopperRepository;
import com.amirhossein.salesinvoice.services.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private ProductRepository productRepository;
    private SellerRepository sellerRepository;
    private ShopperRepository shopperRepository;
    private InvoiceToRes invoiceToRes;
    private ReqToInvoice reqToInvoice;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, ProductRepository productRepository, SellerRepository sellerRepository, ShopperRepository shopperRepository, InvoiceToRes invoiceToRes, ReqToInvoice reqToInvoice) {
        this.invoiceRepository = invoiceRepository;
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.shopperRepository = shopperRepository;
        this.invoiceToRes = invoiceToRes;
        this.reqToInvoice = reqToInvoice;
    }

    @Override
    public List<InvoiceRes> getAllInvoices() {

        List<Invoice> invoices = invoiceRepository.findAll();

        List<InvoiceRes> res = new ArrayList<>();

        for (int i = 0; i < invoices.size(); i++) {
            res.add(invoiceToRes.convert(invoices.get(i)));
        }

        return res;
    }

    @Override
    public InvoiceRes createInvoice(InvoiceReq invoiceReq) {

        Invoice invoice = reqToInvoice.convert(invoiceReq);

        invoiceRepository.save(invoice);

        InvoiceRes res = invoiceToRes.convert(invoice);

        return res;
    }
}
