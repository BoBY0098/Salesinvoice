package com.amirhossein.salesinvoice.models.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductCountReq {

    @ApiModelProperty(required = true)
    private UUID productId;

    @ApiModelProperty(required = true)
    private Integer count;
}
