package com.invoice.gateway;

import com.invoice.products.ProductsDTO;
import com.invoice.products.ProductsExternalAPI;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsExternalAPI productsExternalAPI;

    public ProductsController(ProductsExternalAPI productsExternalAPI) {
        this.productsExternalAPI = productsExternalAPI;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductsDTO> getProductByI(@PathVariable("id") Long id){
        return ResponseEntity.ok(productsExternalAPI.getProductById(id));
    }
    @GetMapping
    public ResponseEntity<List<ProductsDTO>> all(){
        return ResponseEntity.ok(productsExternalAPI.getAllProducts());
    }
    @PostMapping
    public ResponseEntity<ProductsDTO> save(@RequestBody ProductsDTO productsDTO){
        return ResponseEntity.ok(productsExternalAPI.saveProduct(productsDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductsDTO> update(@PathVariable("id") Long id,@RequestBody @Valid ProductsDTO productsDTO){
        return ResponseEntity.ok(productsExternalAPI.updateProduct(id, productsDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductsDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(productsExternalAPI.deleteProduct(id));
    }
}
