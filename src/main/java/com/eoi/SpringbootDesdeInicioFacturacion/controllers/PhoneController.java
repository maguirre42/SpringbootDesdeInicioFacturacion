package com.eoi.SpringbootDesdeInicioFacturacion.controllers;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Phone;

import com.eoi.SpringbootDesdeInicioFacturacion.services.PhoneService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;



import java.util.List;

import java.util.Optional;



@Controller

@RequestMapping("/phones")

public class PhoneController {



    @Autowired

    private PhoneService phoneService;



    @GetMapping(value = {"/",""})

    public String getAllPhones(Model model) {

        List<Phone> phones = phoneService.findAll();

        model.addAttribute("phones", phones);

        return "phone-list";

    }



    @GetMapping("/{id}")

    public String getPhoneById(@PathVariable Long id, Model model) {

        Optional<Phone> phone = phoneService.findById(id);

        if(phone.isPresent())

        {

            model.addAttribute("phone", phone.get());

            return "phone-form";

        }

        return "error";

    }



    @GetMapping("/new")

    public String newPhone(Model model) {

        Phone phone = new Phone();

        model.addAttribute("phone", phone);

        return "phone-form";

    }



    @PostMapping("/save")

    public String savePhone(Phone phone) {

        phoneService.save(phone);

        return "redirect:/phones/";

    }



    @GetMapping("/edit/{id}")

    public String editPhone(@PathVariable Long id, Model model) {

        Optional<Phone> phone = phoneService.findById(id);

        if (phone.isPresent())

        {

            model.addAttribute("phone", phone);

            return "phone-form";

        }

        return "error";

    }



    @GetMapping("/delete/{id}")

    public String deletePhone(@PathVariable Long id) {

        phoneService.deleteById(id);

        return "redirect:/phones/";

    }

}