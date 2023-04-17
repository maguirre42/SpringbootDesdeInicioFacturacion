package com.eoi.SpringbootDesdeInicioFacturacion.controllers;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Customer;
import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Invoice;
import com.eoi.SpringbootDesdeInicioFacturacion.services.CustomerService;
import com.eoi.SpringbootDesdeInicioFacturacion.services.InvoiceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
// Cualquier tipo de request en bueno (get/put/post/delete)
@RequestMapping("/customers") // Al ponerlo antes de la clase, cualquier método que tenga esta clase, va tener como prefijo.
@Log4j2
public class CustomerController {
    @Autowired // No se necesita crear una instancia de CustomerService porque Spring lo hace automaticamente
    private CustomerService  customerService;
    // Para acceder a los métodos avanzados del servicio

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(value = {"/", ""})
    public String showCustomers(Model model) {
        // Creamos atributos "customers" que contine todos los customeros mediante el método findAll del servicio
        model.addAttribute("customers", customerService.findAll());
        // Devuelve el nombre de la vista (html) que queremos mostrar
        // El combo de SpringBootWeb y Thymeleaf nos permite usar el nombre de la vista sin poner la extensión.
        return "customer-list";
    }
    @GetMapping("/new")
    public String showNewCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers/";
    }
    @GetMapping("/edit/{id}")
    public String showEditCustomerForm(@PathVariable("id") Long id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()){
            model.addAttribute("customer", customer.get());
        }else{
            return "error-page";
        }
        return "customer-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteById(id);
        return "redirect:/customers/";
    }

    @GetMapping("/{id}/invoices/new")

    public String newInvoiceForm(@PathVariable("id") Long id, Model model) {

        Optional<Customer> customer = customerService.findById(id);

        if(customer.isPresent()){
            Invoice invoice = new Invoice();
            invoice.setCustomer(customer.get());
            model.addAttribute("invoice", invoice);
            return "customer-invoice-form";
        }else {
            return "error";
        }
    }

    @PostMapping("/{id}/invoices/new")

    public String createInvoice(@PathVariable("id") Long id, @ModelAttribute("invoice") Invoice invoice) {

        Optional<Customer> customer = customerService.findById(id);

        if(customer.isPresent()){
            invoice.setCustomer(customer.get());
            invoiceService.save(invoice);
            return "redirect:/customers/edit" + id; // El id redireccciona a la página del cliente.
        } else
        {
            return "error";
        }
    }
}
