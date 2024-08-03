package com.invoice.providers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.providers.validations.anotations.ValidContactProvider;
import com.invoice.providers.validations.anotations.ValidNameProvider;
import com.invoice.providers.validations.anotations.ValidPhoneProvider;
import com.invoice.providers.validations.anotations.ValidRutProvider;
import jakarta.validation.constraints.Email;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderDTO (
         Long id,
         @ValidRutProvider String rut,
         @ValidNameProvider String name,
         @ValidPhoneProvider String phone,
         @Email(message = "{custom.email-validation-provider.message}") String email,
         @ValidContactProvider String contact){
}
