package com.eoi.SpringbootDesdeInicioFacturacion.services;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Customer;
import com.eoi.SpringbootDesdeInicioFacturacion.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired // Data Injection, access to the repository to make CRUD operations with objects
    private CustomerRepository   customerRepository;

    // Instancia el InnvoiceRepository automáticamente para usarse cuando se necesite

    // Implementación de métodos principales que se usan al entrar en el CRUD
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    // Objeto de tipo opcional que contrala si un objeto existe o no.
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
    public void deleteById(Long id){
        customerRepository.deleteById(id);
    }
}
