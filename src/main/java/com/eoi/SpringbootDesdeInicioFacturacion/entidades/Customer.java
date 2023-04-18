package com.eoi.SpringbootDesdeInicioFacturacion.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*    @Column(name = "name")*/
    private String name;
    /*    @Column(name = "apellido")*/
    private String apellido;
    /*    @Column(name = "edad")*/
    private Integer edad;
    /*    @Column(name = "fecha de nacimiento")*/
    private LocalDate fechaNacimiento;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)  // Cascade types: se define en las relaciones entre entidades hay que investigar que tipo de cascada se debe utilizar
    /* An analogy between FetchType.LAZY and FetchType.EAGER by using a library system where books and authors are stored in separate rooms (Lazy) and in the same room (Eager).
    If FetchType.LAZY is used, the associated entity (Author) will not be loaded until it is accessed, similar to going to the separate room to get author information when needed.
    In contrast, if FetchType.EAGER is used, the associated entity will be loaded along with the entity it is related to (Book), similar to getting all information (book and author) in the same room. */
    private List<Invoice> invoices;

    @JsonManagedReference

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private List<Contract> contracts;
}
