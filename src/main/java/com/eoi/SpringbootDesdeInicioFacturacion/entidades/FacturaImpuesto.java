package com.eoi.SpringbootDesdeInicioFacturacion.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "factura_impuesto") // Nombre de la tabla
public class FacturaImpuesto {
    @EmbeddedId // Indica que el id tiene columnas multiples
    private FacturaImpuestoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("facturaId")
    @JoinColumn(name = "factura_id")
    private Invoice factura;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("impuestoId")
    @JoinColumn(name = "impuesto_id")
    private Tax impuesto;

    @Column(name = "total_impuesto")
    private Double totalImpuesto;

    // getters y setters
}