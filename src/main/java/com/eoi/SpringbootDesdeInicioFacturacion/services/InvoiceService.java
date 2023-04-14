package com.eoi.SpringbootDesdeInicioFacturacion.services;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Invoice;
import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Product;
import com.eoi.SpringbootDesdeInicioFacturacion.repositories.InvoiceRepository;
import com.eoi.SpringbootDesdeInicioFacturacion.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired // Data Injection, access to the repository to make CRUD operations with objects
    private InvoiceRepository   invoiceRepository;

    // Instancia el InnvoiceRepository automáticamente para usarse cuando se necesite

    // Implementación de métodos principales que se usan al entrar en el CRUD
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }
    // Objeto de tipo opcional que contrala si un objeto existe o no.
    public Optional<Invoice> findById(Long id) {
        return invoiceRepository.findById(id);
    }
    public Invoice save(Invoice invoice){
        return invoiceRepository.save(invoice);
    }
    public void deleteById(Long id){
        invoiceRepository.deleteById(id);
    }
}
