package com.eoi.SpringbootDesdeInicioFacturacion.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invoice")
public class Invoice {
    @Column(name = "id_invoice")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*    @Column(name = "codigo de factura")*/
    private String codigoFactura;
    /*    @Column(name = "Fecha")*/
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer")
    /*    @Column(name = "customer (aquí se pone la columna con la cual se une")*/
    private Customer customer;
}
