package com.amirhossein.salesinvoice.services.impl;

import com.amirhossein.salesinvoice.components.NumberGenerator;
import com.amirhossein.salesinvoice.converters.invoice.InvoiceToRes;
import com.amirhossein.salesinvoice.converters.product.ReqToProduct;
import com.amirhossein.salesinvoice.converters.seller.ReqToSeller;
import com.amirhossein.salesinvoice.converters.shopper.ReqToShopper;
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
    private ReqToProduct reqToProduct;
    private ReqToSeller reqToSeller;
    private ReqToShopper reqToShopper;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, ProductRepository productRepository, SellerRepository sellerRepository, ShopperRepository shopperRepository, InvoiceToRes invoiceToRes, ReqToProduct reqToProduct, ReqToSeller reqToSeller, ReqToShopper reqToShopper) {
        this.invoiceRepository = invoiceRepository;
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.shopperRepository = shopperRepository;
        this.invoiceToRes = invoiceToRes;
        this.reqToProduct = reqToProduct;
        this.reqToSeller = reqToSeller;
        this.reqToShopper = reqToShopper;
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
        // check and set invoice number
        if (invoiceReq.getNumber() == null || invoiceReq.getNumber().equals(""))
            invoiceReq.setNumber(NumberGenerator.getRandomNumberString());

        Invoice newInvoice = new Invoice();



        if (invoiceReq.getGenerateNum()) {

            Invoice invoice = new Invoice();

            invoice.setDate(invoiceReq.getDate());
            invoice.setInvoiceNum();

            /*if (invoiceReq.getProductId() != null) {
                invoice.getCounts().add(invoiceReq.getCounts().get()).get();

            } else {
                for (int i = 0; i < invoiceReq.getProductReqs().size(); i++) {
                    invoice.getProducts().add(productRepository.save(reqToProduct.convert(invoiceReq.getProductReqs().get(i))));

                }
            }*/

            for (int i = 0; i < invoiceReq.getProductReqs().size(); i++) {
                if (invoiceReq.getProductId() != null) {
                    invoice.getCounts().add();

                }

                invoice.setSeller(sellerRepository.findById(invoiceReq.getSellerId()).get());

                invoice.setShopper(shopperRepository.findById(invoiceReq.getShopperId()).get());

                invoiceRepository.save(invoice);

                InvoiceRes res = invoiceToRes.convert(invoice);

                return res;

            } else{

                Invoice invoice = new Invoice();

                invoice.setDate(invoiceReq.getDate());
                invoice.setInvoiceNum(invoiceNum);

                if (invoiceReq.getProductId() != null) {
                    invoice.getProducts().add(productRepository.findById(invoiceReq.getProductId()).get());

                } else {
                    for (int i = 0; i < invoiceReq.getProductReqs().size(); i++) {
                        invoice.getProducts().add(productRepository.save(reqToProduct.convert(invoiceReq.getProductReqs().get(i))));

                    }

                }

                invoice.setSeller(sellerRepository.findById(invoiceReq.getSellerId()).get());

                invoice.setShopper(shopperRepository.findById(invoiceReq.getShopperId()).get());

                invoiceRepository.save(invoice);

                InvoiceRes res = invoiceToRes.convert(invoice);

                return res;
            }

            // return null;
        }
    }




