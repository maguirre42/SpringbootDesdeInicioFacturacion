package com.eoi.SpringbootDesdeInicioFacturacion.repositories;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Creamos el método aqui para que funcione el ProductService
    // El JpaRepository ya tiene los métodos CRUD
    // JPA nos permite asumir que al crear este método, vamos a crear una QUERY para buscar algo por nombre en una BBDD

/*    Optional<Product> findbyname(String name);*/
}
