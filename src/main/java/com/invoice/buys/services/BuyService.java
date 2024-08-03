package com.invoice.buys.services;

import com.invoice.buys.BuyDTO;
import com.invoice.buys.BuyExternalAPI;
import com.invoice.buys.exceptions.BuyNotFoundException;
import com.invoice.buys.mappers.BuyMapper;
import com.invoice.buys.models.Buy;
import com.invoice.buys.repositories.BuyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BuyService implements BuyExternalAPI {
    BuyRepository buyRepository;
    BuyMapper buyMapper;
    @Override
    public BuyDTO getBuyById(Long id) {
        return buyMapper.buyToBuyDTO(buyRepository.findById(id).orElseThrow(BuyNotFoundException::new));
    }

    @Override
    public List<BuyDTO> getAllBuys() {
        return buyRepository.findAll()
                .stream()
                .map(buy -> buyMapper.buyToBuyDTO(buy))
                .toList();
    }

    @Override
    public BuyDTO saveBuy(BuyDTO buyDTO) {
        return buyMapper.buyToBuyDTO(buyRepository.save(buyMapper.buyDTOToBuy(buyDTO)));
    }

    @Override
    public BuyDTO deleteBuy(Long id) {
        Buy buy = buyMapper.buyDTOToBuy(getBuyById(id));
        BuyDTO buyDTO = buyMapper.buyToBuyDTO(buy);
        buyRepository.delete(buy);
        return buyDTO;
    }
}
