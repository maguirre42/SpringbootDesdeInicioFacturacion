package com.eoi.SpringbootDesdeInicioFacturacion.repositories;

import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Customer;
import com.eoi.SpringbootDesdeInicioFacturacion.entidades.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
