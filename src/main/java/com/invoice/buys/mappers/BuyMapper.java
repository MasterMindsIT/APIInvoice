package com.invoice.buys.mappers;

import com.invoice.buys.BuyDTO;
import com.invoice.buys.models.Buy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BuyMapper {
    BuyMapper INSTANCE = Mappers.getMapper(BuyMapper.class);
    BuyDTO buyToBuyDTO(Buy buy);
    Buy buyDTOToBuy(BuyDTO buyDTO);
}
