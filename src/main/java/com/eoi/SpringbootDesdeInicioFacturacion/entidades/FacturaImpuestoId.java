package com.eoi.SpringbootDesdeInicioFacturacion.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FacturaImpuestoId implements Serializable {
    @Column(name = "factura_id")
    private Long facturaId;

    @Column(name = "impuesto_id")
    private Long impuestoId;

    // getters y setters
}