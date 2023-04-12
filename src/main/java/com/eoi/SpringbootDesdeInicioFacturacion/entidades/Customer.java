package com.eoi.SpringbootDesdeInicioFacturacion.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private Integer id;
    String name;
}
