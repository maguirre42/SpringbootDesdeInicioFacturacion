package com.eoi.SpringbootDesdeInicioFacturacion.repositories;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
