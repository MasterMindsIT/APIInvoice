package com.invoice.gateway;

import com.invoice.invoices.InvoiceDTO;
import com.invoice.invoices.InvoiceExternalAPI;
import com.invoice.products.ProductsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("invoices")
public class InvoiceController {
    private InvoiceExternalAPI invoiceExternalAPI;
    public InvoiceController(InvoiceExternalAPI invoiceExternalAPI) {
        this.invoiceExternalAPI = invoiceExternalAPI;
    }
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> findById(@PathVariable("id")Long id){
        return ResponseEntity.ok(invoiceExternalAPI.getInvoiceId(id));
    }
    @GetMapping
    public ResponseEntity<List<InvoiceDTO>> all(){
        return ResponseEntity.ok(invoiceExternalAPI.getAllInvoice());
    }
    @PostMapping
    public ResponseEntity<InvoiceDTO> save(@RequestBody InvoiceDTO invoiceDTO){
        return ResponseEntity.ok(invoiceExternalAPI.saveInvoice(invoiceDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InvoiceDTO>  delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(invoiceExternalAPI.deleteInvoice(id));
    }

}
