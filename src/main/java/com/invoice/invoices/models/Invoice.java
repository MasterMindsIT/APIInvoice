package com.invoice.invoices.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberInvoice;
    private double mount;
    private Date day;
    private Date hour;
    private String note;
    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<DetailInvoice> detailInvoice;

    //FK
    private Long user_id;
    private int authorizedInvoice;
    private double discount_id;

}