package com.eoi.SpringbootDesdeInicioFacturacion.repositories;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Customer;
import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
