package com.invoice.gateway;

import com.invoice.providers.ProviderDTO;
import com.invoice.providers.ProviderExternalAPI;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    private final ProviderExternalAPI providerExternalAPI;

    public ProviderController(ProviderExternalAPI providerExternalAPI) {
        this.providerExternalAPI = providerExternalAPI;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(providerExternalAPI.getProviderById(id));
    }
    @GetMapping
    public ResponseEntity<List<ProviderDTO>> all(){
        return ResponseEntity.ok(providerExternalAPI.getAllProvider());
    }
    @PostMapping
    public ResponseEntity<ProviderDTO> save(@RequestBody @Valid ProviderDTO providerDTO){
        return ResponseEntity.ok(providerExternalAPI.saveProvider(providerDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProviderDTO> update(@PathVariable("id")Long id, @RequestBody @Valid ProviderDTO providerDTO){
        return ResponseEntity.ok(providerExternalAPI.updateProvider(id, providerDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProviderDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(providerExternalAPI.deleteProvider(id));
    }

}
