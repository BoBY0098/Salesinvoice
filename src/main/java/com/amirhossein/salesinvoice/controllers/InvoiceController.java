package com.amirhossein.salesinvoice.controllers;

import com.amirhossein.salesinvoice.models.invoice.InvoiceReq;
import com.amirhossein.salesinvoice.models.invoice.InvoiceRes;
import com.amirhossein.salesinvoice.services.service.InvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "invoices")
@RequestMapping("/invoices")
public class InvoiceController {

    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping()
    @ApiOperation(value = "Get All Invoices" , notes = "Get All Invoices" , response = InvoiceRes.class , responseContainer = "List")
    public ResponseEntity<?> getAllInvoices(){
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @PostMapping()
    @ApiOperation(value = "Create New a Invoice" , notes = "If you want to Generate Random Number for InvoiceNum , Please Select True for generateNum and Type in box 6 Digit Number" , response = InvoiceRes.class)
    public ResponseEntity<?> createInvoice(@RequestBody InvoiceReq invoiceReq){
        return ResponseEntity.ok(invoiceService.createInvoice(invoiceReq));
    }
}
