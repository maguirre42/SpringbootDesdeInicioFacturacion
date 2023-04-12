package com.eoi.SpringbootDesdeInicioFacturacion.controllers;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Product;
import com.eoi.SpringbootDesdeInicioFacturacion.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// Cualquier tipo de request en bueno (get/put/post/delete)
@RequestMapping("/products") // Al ponerlo antes de la clase, cualquier método que tenga esta clase, va tener como prefijo.
public class ProductController {
    @Autowired // No se necesita crear una instancia de ProductService porque Spring lo hace automaticamente
    private ProductService  productService;
    // Para acceder a los métodos avanzados del servicio

    @GetMapping("/")
    public String showProducts(Model model) {
        // Creamos atributos "products" que contine todos los productos mediante el método findAll del servicio
        model.addAttribute("products", productService.findAll());
        // Devuelve el nombre de la vista (html) que queremos mostrar
        // El combo de SpringBootWeb y Thymeleaf nos permite usar el nombre de la vista sin poner la extensión.
        return "product-list";
    }
    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/products/";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/products/";
    }
}
