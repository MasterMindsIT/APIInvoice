package com.invoice.gateway;

import com.invoice.inventories.InventoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.invoice.inventories.InventoryExternalAPI;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    private InventoryExternalAPI inventoryExternalAPI;
    public InventoryController(InventoryExternalAPI inventoryExternalAPI) {
        this.inventoryExternalAPI = inventoryExternalAPI;
    }
    @GetMapping("/{id}")
    public ResponseEntity<InventoryDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(inventoryExternalAPI.getInventoryById(id));
    }
    @GetMapping
    public ResponseEntity<List<InventoryDTO>> all(){
        return ResponseEntity.ok(inventoryExternalAPI.getAllInventories());
    }
    @PostMapping
    public ResponseEntity<InventoryDTO> save(@RequestBody InventoryDTO inventoryDTO){
        return ResponseEntity.ok(inventoryExternalAPI.saveInventory(inventoryDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<InventoryDTO> update(@PathVariable("id") Long id, @RequestBody @Valid InventoryDTO inventoryDTO){
        return ResponseEntity.ok(inventoryExternalAPI.updateInventory(id, inventoryDTO));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<InventoryDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(inventoryExternalAPI.deleteInventory(id));
    }
}