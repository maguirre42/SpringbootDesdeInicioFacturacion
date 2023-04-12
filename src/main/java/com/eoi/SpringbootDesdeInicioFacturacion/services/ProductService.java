package com.eoi.SpringbootDesdeInicioFacturacion.services;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Product;
import com.eoi.SpringbootDesdeInicioFacturacion.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired // Data Injection, access to the repository to make CRUD operations with objects
    private ProductRepository productRepository;

    // Instancia el ProductRepository automáticamente para usarse cuando se necesite

    // Implementación de métodos principales que se usan al entrar en el CRUD
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Objeto de tipo opcional que contrala si un objeto existe o no.
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

/*    public Optional<Product> findByName(String name) {
        return productRepository.findbyname(name);
        // Se necesita añadir el metodo en ProductRepository
    }*/

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
