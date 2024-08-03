package com.invoice.gateway;

import com.invoice.discount.DiscountDTO;
import com.invoice.discount.DiscountExternalAPI;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountsController {
    private final DiscountExternalAPI discountExternalAPI;

    public DiscountsController(DiscountExternalAPI discountExternalAPI) {
        this.discountExternalAPI = discountExternalAPI;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(discountExternalAPI.getDiscountById(id));
    }

    @GetMapping
    public ResponseEntity<List<DiscountDTO>> getAllDiscounts() {
        return ResponseEntity.ok(discountExternalAPI.getAllDiscounts());
    }

    @PostMapping
    public ResponseEntity<DiscountDTO> saveDiscount(@RequestBody @Valid DiscountDTO discountDTO) {
        return ResponseEntity.ok(discountExternalAPI.saveDiscount(discountDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountDTO> updateDiscount(@PathVariable("id") Long id, @RequestBody @Valid DiscountDTO discountDTO) {
        return ResponseEntity.ok(discountExternalAPI.updateDiscount(id, discountDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DiscountDTO> deleteDiscount(@PathVariable("id") Long id) {
        return ResponseEntity.ok(discountExternalAPI.deleteDiscount(id));
    }
}