package com.amirhossein.salesinvoice.controllers;

import com.amirhossein.salesinvoice.models.invoice.InvoiceReq;
import com.amirhossein.salesinvoice.models.invoice.InvoiceRes;
import com.amirhossein.salesinvoice.services.service.InvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.validation.constraints.Max;

@RestController
@Api(tags = "manage-invoices")
@RequestMapping("/manage/invoices")
public class InvoiceManageController {

    private InvoiceService invoiceService;

    public InvoiceManageController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping()
    @ApiOperation(value = "Get All Invoices" , notes = "Get All Invoices" , response = InvoiceRes.class , responseContainer = "List" , authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> getAllInvoices(){
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @PostMapping()
    @ApiOperation(value = "Create New a Invoice" , notes = "If you want to Generate Random Number for InvoiceNum , Please Select True for generateNum and Type in box 6 Digit Number" , response = InvoiceRes.class , authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> createInvoice(@RequestBody InvoiceReq invoiceReq , @RequestParam() Boolean generateNum , @RequestParam(value = "6 Digit Number" , required = false) String invoiceNum){
        return ResponseEntity.ok(invoiceService.createInvoice(invoiceReq , generateNum , invoiceNum));
    }
}
