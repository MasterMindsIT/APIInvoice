package com.invoice.gateway;

import com.invoice.buys.BuyDTO;
import com.invoice.buys.BuyExternalAPI;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("buys")
public class BuyController {
    private BuyExternalAPI buyExternalAPI;

    public BuyController(BuyExternalAPI buyExternalAPI) {
        this.buyExternalAPI = buyExternalAPI;
    }
    @GetMapping("/{id}")
    public ResponseEntity<BuyDTO> findById(@PathVariable("id")Long id){
        return ResponseEntity.ok(buyExternalAPI.getBuyById(id));
    }
    @GetMapping
    public ResponseEntity<List<BuyDTO>> all(){
        return ResponseEntity.ok(buyExternalAPI.getAllBuys());
    }
    @PostMapping
    public ResponseEntity<BuyDTO> save(@RequestBody @Valid BuyDTO buyDTO){
        return ResponseEntity.ok(buyExternalAPI.saveBuy(buyDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BuyDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(buyExternalAPI.deleteBuy(id));
    }
}
