package com.invoice.gateway;

import com.invoice.branches.BranchDTO;
import com.invoice.branches.BranchExternalAPI;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {
    private final BranchExternalAPI branchExternalAPI;
    public BranchController(BranchExternalAPI branchExternalAPI) {
        this.branchExternalAPI = branchExternalAPI;
    }

    @GetMapping("/{id}")

    public ResponseEntity<BranchDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(branchExternalAPI.getBranchById(id));
    }
    @GetMapping
    public List<BranchDTO> all(){
        return branchExternalAPI.getAllBranches();
    }
    @PostMapping
    public ResponseEntity<BranchDTO> save(@RequestBody @Valid BranchDTO branchDTO){
        return ResponseEntity.ok(branchExternalAPI.saveBranch(branchDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BranchDTO> update(@PathVariable("id") Long id, @RequestBody @Valid BranchDTO branchDTO){
        return ResponseEntity.ok(branchExternalAPI.updateBranch(id, branchDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BranchDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(branchExternalAPI.deleteBranch(id));
    }
}