package com.invoice.buys;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.buys.validations.anotations.ValidNoteBuy;


import java.util.Date;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record BuyDTO(
        Long id,
        double mount,
        Date day,
        Date hour,
        List<DetailBuyDTO> detailBuyDTO,
       @ValidNoteBuy String note
) {
}
