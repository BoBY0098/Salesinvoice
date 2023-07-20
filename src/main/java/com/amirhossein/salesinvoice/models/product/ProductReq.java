package com.amirhossein.salesinvoice.models.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductReq {

    @ApiModelProperty(required = true)
    private String name;

    @ApiModelProperty(required = true)
    private Long price;

    @ApiModelProperty(notes = "Only if sent as new product in invoice create")
    private Integer invoiceCount;
}
