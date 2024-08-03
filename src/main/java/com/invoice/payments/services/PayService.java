package com.invoice.payments.services;

import com.invoice.payments.PayDTO;
import com.invoice.payments.PayExternalAPI;
import com.invoice.payments.exceptions.PayNotFoundException;
import com.invoice.payments.mappers.PayMapper;
import com.invoice.payments.models.Pay;
import com.invoice.payments.repositories.PayRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PayService implements PayExternalAPI {

    private final PayRepository payRepository;
    private final PayMapper payMapper;

    @Override
    public PayDTO getPayById(Long id) {
        return payMapper.payToPayDTO(payRepository.findById(id).orElseThrow(PayNotFoundException::new));
    }

    @Override
    public List<PayDTO> getAllPays() {
        return payRepository.findAll().stream().map(payMapper::payToPayDTO).toList();
    }

    @Override
    public PayDTO savePay(PayDTO payDTO) {
        Pay pay = payMapper.payDTOToPay(payDTO);
        return payMapper.payToPayDTO(payRepository.save(pay));
    }

    @Override
    public PayDTO updatePay(Long id, PayDTO payDTO) {
        Pay pay = payMapper.payDTOToPay(getPayById(id));
        pay.setName(payDTO.name());
        pay.setDescription(payDTO.description());
        return payMapper.payToPayDTO(payRepository.save(pay));
    }

    @Override
    public PayDTO deletePay(Long id) {
        Pay pay = payMapper.payDTOToPay(getPayById(id));
        PayDTO payDTO = payMapper.payToPayDTO(pay);
        payRepository.delete(pay);
        return payDTO;
    }
}
