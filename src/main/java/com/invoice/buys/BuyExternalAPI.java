package com.invoice.buys;

import java.util.List;

public interface BuyExternalAPI {
    BuyDTO getBuyById(Long id);
    List<BuyDTO> getAllBuys();
    BuyDTO saveBuy(BuyDTO buyDTO);
    BuyDTO deleteBuy(Long id);
}
