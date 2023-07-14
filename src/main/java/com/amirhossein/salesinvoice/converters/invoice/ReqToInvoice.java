package com.amirhossein.salesinvoice.converters.invoice;

import com.amirhossein.salesinvoice.models.invoice.Invoice;
import com.amirhossein.salesinvoice.models.invoice.InvoiceReq;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReqToInvoice implements Converter<InvoiceReq, Invoice> {

    @Override
    public Invoice convert(InvoiceReq input) {

        Invoice output = new Invoice();

        output.setDate(input.getDate());
        output.setInvoiceNum(input.getInvoiceNum());

        return output;
    }
}
