package com.eoi.SpringbootDesdeInicioFacturacion.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate billingDate;

    private BigDecimal amount;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer")
    /*    @Column(name = "customer (aquí se pone la columna con la cual se une")*/
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "factura_impuesto",
            joinColumns = @JoinColumn(name = "factura_id"),
            inverseJoinColumns = @JoinColumn(name = "impuesto_id")
    )
    private List<Tax> impuestos;
    @OneToMany(mappedBy = "invoice")
    @OrderBy("callDate ASC")
    private List<PhoneCall> phoneCalls;

    public BigDecimal getImpuestoTotalPorTasa(BigDecimal tasa) {
        BigDecimal totalImpuesto = BigDecimal.ZERO;
        for (Tax impuesto : impuestos) {
            if (impuesto.getPercentage().equals(tasa)) {
                totalImpuesto = totalImpuesto.add(amount.multiply(impuesto.getPercentage().divide(BigDecimal.valueOf(100))));
            }
        }
        return totalImpuesto;
    }
}
