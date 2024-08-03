package com.invoice.payments.mappers;

import com.invoice.payments.PayDTO;
import com.invoice.payments.models.Pay;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PayMapper {
    PayMapper INSTANCE = Mappers.getMapper(PayMapper.class);

    PayDTO payToPayDTO(Pay pay);
    Pay payDTOToPay(PayDTO payDTO);
}
