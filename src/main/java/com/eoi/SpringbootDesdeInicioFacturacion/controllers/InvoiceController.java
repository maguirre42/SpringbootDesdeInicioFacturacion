package com.eoi.SpringbootDesdeInicioFacturacion.controllers;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Invoice;
import com.eoi.SpringbootDesdeInicioFacturacion.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// Cualquier tipo de request en bueno (get/put/post/delete)
@RequestMapping("/invoices") // Al ponerlo antes de la clase, cualquier método que tenga esta clase, va tener como prefijo.
public class InvoiceController {
    @Autowired // No se necesita crear una instancia de InvoiceService porque Spring lo hace automaticamente
    private InvoiceService  invoiceService;
    // Para acceder a los métodos avanzados del servicio

    @GetMapping(value = {"/", ""})
    public String showInvoices(Model model) {
        // Creamos atributos "invoices" que contine todos los invoiceos mediante el método findAll del servicio
        model.addAttribute("invoices", invoiceService.findAll());
        // Devuelve el nombre de la vista (html) que queremos mostrar
        // El combo de SpringBootWeb y Thymeleaf nos permite usar el nombre de la vista sin poner la extensión.
        return "invoice/invoice-list";
    }
    @GetMapping("/new")
    public String showNewInvoiceForm(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "invoice/invoice-form";
    }
    @PostMapping("/save")
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices/";
    }
    @GetMapping("/edit/{id}")
    public String showEditInvoiceForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("invoice", invoiceService.findById(id));
        return "invoice/customer-invoice-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable("id") Long id) {
        invoiceService.deleteById(id);
        return "redirect:/invoices/";
    }
}
