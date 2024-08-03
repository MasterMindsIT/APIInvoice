package com.invoice.buys.models;

import com.invoice.invoices.models.DetailInvoice;
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
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double mount;
    private Date day;
    private Date hour;
    private String note;
    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<DetailBuy> detailBuy;

    //FK
    private Long userId;
    private Long providerId;
}
