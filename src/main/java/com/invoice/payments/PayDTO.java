package com.invoice.payments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.payments.validations.anotations.ValidDescriptionPay;
import com.invoice.payments.validations.anotations.ValidNamePay;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PayDTO (
        Long id,
        @ValidNamePay String name,
        @ValidDescriptionPay String description) {
}
