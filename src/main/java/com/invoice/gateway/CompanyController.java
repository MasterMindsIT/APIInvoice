package com.invoice.gateway;

import com.invoice.companies.CompanyDTO;
import com.invoice.companies.CompanyExternalAPI;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {
    private CompanyExternalAPI companyExternalAPI;

    public CompanyController(CompanyExternalAPI companyExternalAPI) {
        this.companyExternalAPI = companyExternalAPI;
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable("id")Long id){
        return ResponseEntity.ok(companyExternalAPI.getCompanyById(id));
    }
    @GetMapping
    public ResponseEntity<List<CompanyDTO>> all(){
        return ResponseEntity.ok(companyExternalAPI.getAllCompanies());
    }
    @PostMapping
    public ResponseEntity<CompanyDTO> save(@RequestBody @Valid CompanyDTO companyDTO){
        return ResponseEntity.ok(companyExternalAPI.saveCompany(companyDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> update(@PathVariable("id") Long id, @RequestBody @Valid CompanyDTO companyDTO){
        return ResponseEntity.ok(companyExternalAPI.updateCompany(id, companyDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CompanyDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(companyExternalAPI.deleteCompany(id));
    }
}