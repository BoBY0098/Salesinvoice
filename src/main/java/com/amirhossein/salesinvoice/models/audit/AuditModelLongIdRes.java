package com.amirhossein.salesinvoice.models.audit;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public abstract class AuditModelLongIdRes {

    private Long id;
}
