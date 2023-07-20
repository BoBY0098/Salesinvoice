package com.amirhossein.salesinvoice.models.invoice;

import com.amirhossein.salesinvoice.models.product.ProductCountReq;
import com.amirhossein.salesinvoice.models.product.ProductReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class InvoiceReq {

    @ApiModelProperty(notes = "If empty or null it will generate")
    private String number;

    @ApiModelProperty(required = true)
    private Date date;

    @ApiModelProperty(required = true)
    private UUID sellerId;

    @ApiModelProperty(required = true)
    private UUID shopperId;

    @ApiModelProperty(notes = "If empty you must fill new product(s)")
    private List<ProductCountReq> existProducts;

    @ApiModelProperty(notes = "If empty you must fill exist product(s)")
    private List<ProductReq> newProducts = new ArrayList<>();
}
