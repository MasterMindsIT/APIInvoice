package com.invoice.gateway;

import com.invoice.taxes.TaxesDTO;
import com.invoice.taxes.TaxesExternalAPI;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("taxes")
public class TaxesController {
    private TaxesExternalAPI taxesExternalAPI;

    public TaxesController(TaxesExternalAPI taxesExternalAPI) {
        this.taxesExternalAPI = taxesExternalAPI;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaxesDTO> findById(@PathVariable("id")Long id){
        return ResponseEntity.ok(taxesExternalAPI.getTaxesById(id));
    }
    @GetMapping
    public ResponseEntity<List<TaxesDTO>> allTaxes(){
        return ResponseEntity.ok(taxesExternalAPI.getAllTaxes());
    }
    @PostMapping
    public ResponseEntity<TaxesDTO> saveTaxes(@RequestBody @Valid TaxesDTO taxesDTO){
        return ResponseEntity.ok(taxesExternalAPI.saveTaxes(taxesDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaxesDTO> updateTaxes(@PathVariable("id") Long id, @RequestBody @Valid TaxesDTO taxesDTO){
        return ResponseEntity.ok(taxesExternalAPI.updateTaxes(id, taxesDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TaxesDTO> deleteTaxes(@PathVariable("id") Long id){
        return ResponseEntity.ok(taxesExternalAPI.deleteTaxes(id));
    }
}