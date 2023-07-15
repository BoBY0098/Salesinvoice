package com.amirhossein.salesinvoice.models.response;

import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExceptionResponse {

    private Integer status;
    private List<String> messages = new ArrayList<>();

    public ExceptionResponse(int status) {
        this.status = status;
    }

    public ExceptionResponse(int status, List<String> messages) {
        this.status = status;
        this.messages = messages;
    }

    public ExceptionResponse(int status, String message) {
        this.status = status;
        this.messages.add(message);
    }

    public ExceptionResponse(int status, BindingResult bindingResult) {
        this.status = status;
        for (Object object : bindingResult.getAllErrors())
            messages.add(((FieldError) object).getDefaultMessage());
    }
}
