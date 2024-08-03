package com.invoice.gateway;

import com.invoice.roles.RoleDTO;
import com.invoice.roles.RoleExternalAPI;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private  final RoleExternalAPI roleExternalAPI;
    public RoleController(RoleExternalAPI roleExternalAPI) {
        this.roleExternalAPI = roleExternalAPI;
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(roleExternalAPI.getRoleById(id));
    }
    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAll(){
        return ResponseEntity.ok(roleExternalAPI.getAllRole());
    }
    @PostMapping
    public ResponseEntity<RoleDTO> save(@RequestBody @Valid RoleDTO roleDTO, HttpServletRequest request){
        RoleDTO newRole = roleExternalAPI.saveRole(roleDTO);
        String baseUrl = request.getRequestURL().toString();
        URI newLocation = URI.create(baseUrl+"/"+newRole.id());
        return ResponseEntity.created(newLocation).body(newRole);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> update(@PathVariable("id") Long id, @RequestBody RoleDTO roleDTO){
        return ResponseEntity.accepted().body(roleExternalAPI.updateRole(id, roleDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        roleExternalAPI.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
