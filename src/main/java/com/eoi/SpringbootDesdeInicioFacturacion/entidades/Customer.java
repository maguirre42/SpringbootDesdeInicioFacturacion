package com.eoi.SpringbootDesdeInicioFacturacion.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "invoiceToCustomer", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Invoice> invoiceList = new ArrayList<>();
}
