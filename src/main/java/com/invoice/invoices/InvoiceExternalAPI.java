package com.invoice.invoices;

import java.util.List;

public interface InvoiceExternalAPI {
    InvoiceDTO getInvoiceId(Long id);
    List<InvoiceDTO> getAllInvoice();
    InvoiceDTO saveInvoice(InvoiceDTO invoiceDTO);

    InvoiceDTO deleteInvoice(Long id);
}
