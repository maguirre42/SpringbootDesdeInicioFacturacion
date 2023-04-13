package com.eoi.SpringbootDesdeInicioFacturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication esto es lo normal*/
@SpringBootApplication (exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}) // Para evitar que la seguridad se ejecute en nuestra aplicación
public class SpringbootDesdeInicioFacturacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDesdeInicioFacturacionApplication.class, args);
	}

}
