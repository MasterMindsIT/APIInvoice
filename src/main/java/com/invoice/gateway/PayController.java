package com.invoice.gateway;

import com.invoice.payments.PayDTO;
import com.invoice.payments.PayExternalAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pays")
public class PayController {

    private final PayExternalAPI payExternalAPI;

    public PayController(PayExternalAPI payExternalAPI) {
        this.payExternalAPI = payExternalAPI;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(payExternalAPI.getPayById(id));
    }

    @GetMapping
    public ResponseEntity<List<PayDTO>> all() {
        return ResponseEntity.ok(payExternalAPI.getAllPays());
    }

    @PostMapping
    public ResponseEntity<PayDTO> save(@RequestBody PayDTO payDTO) {
        return ResponseEntity.ok(payExternalAPI.savePay(payDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<PayDTO> update(@PathVariable("id") Long id, @RequestBody PayDTO payDTO) {
        return ResponseEntity.ok(payExternalAPI.updatePay(id, payDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PayDTO> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(payExternalAPI.deletePay(id));
    }
}
