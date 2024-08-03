package com.invoice.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.users.validations.anotations.profile.ValidAddressProfile;
import com.invoice.users.validations.anotations.profile.ValidLastNameProfile;
import com.invoice.users.validations.anotations.profile.ValidNameProfile;

import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProfileDTO(
        Long id,
        @ValidNameProfile String name,
        @ValidLastNameProfile String last_name,
        Date birthday,
        @ValidAddressProfile String address,
        String personal_id
) {
}
