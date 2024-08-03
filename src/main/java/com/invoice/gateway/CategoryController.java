package com.invoice.gateway;

import com.invoice.categories.CategoryDTO;
import com.invoice.categories.CategoryExternalAPI;
import com.invoice.categories.exceptions.CategoryNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private CategoryExternalAPI categoryExternalAPI;

    public CategoryController(CategoryExternalAPI categoryExternalAPI) {
        this.categoryExternalAPI = categoryExternalAPI;
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable("id")Long id){

        return ResponseEntity.ok(categoryExternalAPI.getCategoryyId(id));

    }
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> all(){
        return ResponseEntity.ok(categoryExternalAPI.getAllCategory());
    }
    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody @Valid CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryExternalAPI.saveCategory(categoryDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable("id") Long id,@RequestBody @Valid CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryExternalAPI.updateCategory(id, categoryDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(categoryExternalAPI.deleteCategory(id));
    }
}
