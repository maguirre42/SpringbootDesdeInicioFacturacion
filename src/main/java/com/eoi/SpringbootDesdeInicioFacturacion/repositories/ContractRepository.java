package com.eoi.SpringbootDesdeInicioFacturacion.repositories;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Contract;
import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
