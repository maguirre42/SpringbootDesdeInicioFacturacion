package com.eoi.SpringbootDesdeInicioFacturacion.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
/*    @Column(name = "id")*/
    private Long id;
/*    @Column(name = "name")*/
    private String name;
/*    @Column(name = "description")*/
    private String description;
/*    @Column(name = "price")*/
    private Double price;
}
// Constructor, getters y setters
