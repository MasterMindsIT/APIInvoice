package com.invoice.payments;

import java.util.List;

public interface PayExternalAPI {
    PayDTO getPayById(Long id);
    List<PayDTO> getAllPays();
    PayDTO savePay(PayDTO payDTO);
    PayDTO updatePay(Long id, PayDTO payDTO);
    PayDTO deletePay(Long id);
}
