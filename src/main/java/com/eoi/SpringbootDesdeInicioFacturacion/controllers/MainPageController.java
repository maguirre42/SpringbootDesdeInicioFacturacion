package com.eoi.SpringbootDesdeInicioFacturacion.controllers;

import com.eoi.SpringbootDesdeInicioFacturacion.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(value = {"/",""})
    public String showHome(Model model) {
        model.addAttribute("fragmentName", "fragment-invoice-list");
        model.addAttribute("dataObject", invoiceService.findAll());
        return "index";
    }
}
