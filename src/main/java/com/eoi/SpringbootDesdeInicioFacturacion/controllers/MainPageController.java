package com.eoi.SpringbootDesdeInicioFacturacion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    @GetMapping(value = {"/", ""})
    public String showHome () {
        return "home";
    }
}
