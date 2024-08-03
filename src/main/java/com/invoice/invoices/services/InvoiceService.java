package com.invoice.invoices.services;

import com.invoice.invoices.InvoiceDTO;
import com.invoice.invoices.InvoiceExternalAPI;
import com.invoice.invoices.exceptions.InvoiceNotFoundException;
import com.invoice.invoices.mappers.InvoiceMapper;
import com.invoice.invoices.models.Invoice;
import com.invoice.invoices.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class InvoiceService implements InvoiceExternalAPI {
    private InvoiceMapper invoiceMapper;
    private InvoiceRepository invoiceRepository;
    @Override
    public InvoiceDTO getInvoiceId(Long id) {
        return invoiceMapper.invoiceToInvoiceDTO(invoiceRepository
                        .findById(id)
                        .orElseThrow(InvoiceNotFoundException::new));
    }

    @Override
    public List<InvoiceDTO> getAllInvoice() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoice -> invoiceMapper.invoiceToInvoiceDTO(invoice))
                .toList();
    }

    @Override
    public InvoiceDTO saveInvoice(InvoiceDTO invoiceDTO) {
        return invoiceMapper.invoiceToInvoiceDTO(invoiceRepository
                .save(invoiceMapper.invoiceDTOToInvoice(invoiceDTO)
                ));
    }


    @Override
    public InvoiceDTO deleteInvoice(Long id) {
        Invoice invoice = invoiceMapper.invoiceDTOToInvoice(getInvoiceId(id));
        InvoiceDTO invoiceDTO = invoiceMapper.invoiceToInvoiceDTO(invoice);
        invoiceRepository.delete(invoice);
        return invoiceDTO;
    }
}
