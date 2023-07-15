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
    @ApiOperation(value = "Create New a Invoice" , notes = "Create New a Invoice" , response = InvoiceRes.class , authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> createInvoice(@RequestBody InvoiceReq invoiceReq){
        return ResponseEntity.ok(invoiceService.createInvoice(invoiceReq));
    }
}
