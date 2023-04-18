package com.eoi.SpringbootDesdeInicioFacturacion.services;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Phone;

import com.eoi.SpringbootDesdeInicioFacturacion.repositories.PhoneRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import java.util.List;

import java.util.Optional;



@Service

public class PhoneService {

    @Autowired

    private PhoneRepository phoneRepository;



    public List<Phone> findAll() {

        return phoneRepository.findAll();

    }



    public Optional<Phone> findById(Long id) {

        return phoneRepository.findById(id);

    }



    public Phone save(Phone phone) {

        return phoneRepository.save(phone);

    }



    public void deleteById(Long id) {

        phoneRepository.deleteById(id);

    }

}