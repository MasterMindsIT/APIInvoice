package com.invoice.gateway;

import com.invoice.brands.BrandDTO;
import com.invoice.brands.BrandExternalAPI;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/brands")
public class BrandsController {

    private final BrandExternalAPI brandExternalAPI;

    public BrandsController(BrandExternalAPI brandExternalAPI) {
        this.brandExternalAPI = brandExternalAPI;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> findById(@PathVariable("id") Long id){
        System.out.println("ControllerBrand");
        return ResponseEntity.ok(brandExternalAPI.getBrandById(id));
    }
    @GetMapping
    public ResponseEntity<List<BrandDTO>> all(){
        return ResponseEntity.ok(brandExternalAPI.getAllBrands());
    }
    @PostMapping
    public ResponseEntity<BrandDTO> save(@RequestBody @Valid BrandDTO brandDTO){
        return ResponseEntity.ok(brandExternalAPI.saveBrand(brandDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BrandDTO> update(@PathVariable("id") Long id, @RequestBody @Valid BrandDTO brandDTO){
        return ResponseEntity.ok(brandExternalAPI.updateBrand(id, brandDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BrandDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(brandExternalAPI.deleteBrand(id));
    }
}
