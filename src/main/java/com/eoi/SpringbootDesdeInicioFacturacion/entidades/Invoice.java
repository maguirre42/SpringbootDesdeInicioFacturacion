package com.eoi.SpringbootDesdeInicioFacturacion.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Invoice {
    @Id
    private Integer id;
}
