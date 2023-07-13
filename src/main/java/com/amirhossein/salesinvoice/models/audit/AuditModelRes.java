package com.amirhossein.salesinvoice.models.audit;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

@Data
public abstract class AuditModelRes {

    private UUID id;
}
