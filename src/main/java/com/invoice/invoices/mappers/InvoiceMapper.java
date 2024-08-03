package com.invoice.invoices.mappers;

import com.invoice.invoices.InvoiceDTO;
import com.invoice.invoices.models.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);
    InvoiceDTO invoiceToInvoiceDTO(Invoice invoice);
    Invoice invoiceDTOToInvoice (InvoiceDTO invoiceDTO);

}
