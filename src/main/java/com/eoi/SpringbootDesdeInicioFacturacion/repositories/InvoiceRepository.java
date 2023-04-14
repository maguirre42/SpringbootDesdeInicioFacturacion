package com.eoi.SpringbootDesdeInicioFacturacion.repositories;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Invoice;
import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
