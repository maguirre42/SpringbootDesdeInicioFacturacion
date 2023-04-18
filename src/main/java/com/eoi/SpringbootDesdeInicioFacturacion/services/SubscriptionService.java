package com.eoi.SpringbootDesdeInicioFacturacion.services;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Subscription;

import com.eoi.SpringbootDesdeInicioFacturacion.repositories.SubscriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import java.util.List;

import java.util.Optional;



@Service

public class SubscriptionService {

    @Autowired

    private SubscriptionRepository subscriptionRepository;



    public List<Subscription> findAll() {

        return subscriptionRepository.findAll();

    }



    public Optional<Subscription> findById(Long id) {

        return subscriptionRepository.findById(id);

    }



    public Subscription save(Subscription subscription) {

        return subscriptionRepository.save(subscription);

    }



    public void deleteById(Long id) {

        subscriptionRepository.deleteById(id);

    }





}

