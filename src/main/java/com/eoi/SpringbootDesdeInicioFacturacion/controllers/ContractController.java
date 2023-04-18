package com.eoi.SpringbootDesdeInicioFacturacion.controllers;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Contract;

import com.eoi.SpringbootDesdeInicioFacturacion.services.ContractService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;



import java.util.List;

import java.util.Optional;



@Controller

@RequestMapping("/contracts")

public class ContractController {



    @Autowired

    private ContractService contractService;



    // Devuelve una lista de todos los contratos y los agrega al modelo

    @GetMapping(value = {"/",""})

    public String getAllContracts(Model model) {

        List<Contract> contracts = contractService.findAll();

        model.addAttribute("contracts", contracts);

        return "contract-list";

    }



    // Obtiene un contrato por su ID, lo agrega al modelo y devuelve la vista correspondiente

    @GetMapping("/{id}")

    public String getContractById(@PathVariable Long id, Model model) {

        Optional<Contract> contract = contractService.findById(id);

        if(contract.isPresent())

        {

            model.addAttribute("contract", contract.get());

            return "contract-form";

        }

        return "error";

    }



    // Crea un nuevo contrato y lo agrega al modelo

    @GetMapping("/new")

    public String newContract(Model model) {

        Contract contract = new Contract();

        model.addAttribute("contract", contract);

        return "contract-form";

    }



    // Guarda un contrato en la base de datos

    @PostMapping("/save")

    public String saveContract(Contract contract) {

        contractService.save(contract);

        return "redirect:/contracts/";

    }



    // Obtiene un contrato por su ID, lo agrega al modelo y devuelve la vista de edición

    @GetMapping("/edit/{id}")

    public String editContract(@PathVariable Long id, Model model) {

        Optional<Contract> contract = contractService.findById(id);

        if(contract.isPresent())

        {

            model.addAttribute("contract", contract.get());

            return "contract-form";

        }

        return "error";

    }



    // Elimina un contrato de la base de datos

    @GetMapping("/delete/{id}")

    public String deleteContract(@PathVariable Long id) {

        contractService.deleteById(id);

        return "redirect:/contracts/";

    }

}