package com.utn.ejerc02;

import com.utn.ejerc02.entidades.Domicilio;
import com.utn.ejerc02.entidades.Persona;
import com.utn.ejerc02.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejerc02Application {

@Autowired
    PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ejerc02Application.class, args);
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepo) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");
			Persona persona = Persona.builder()
					.nombre("Bruno")
					.apellido("Padilla")
					.edad(20)
					.build();

			Domicilio domicilio = Domicilio.builder()
					.calle("Joaquin V. Gonzalez")
					.numero(938)
					.build();

			// Asocio el domicilio
			persona.setDomicilio(domicilio);

			// Guardar el objeto Persona en la base de datos

			personaRepository.save(persona);

			// Recuperar el objeto Persona desde la base de datos
			Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
				System.out.println("Calle : " + personaRecuperada.getDomicilio().getCalle());
				System.out.println("Número :" + personaRecuperada.getDomicilio().getNumero());
			}

		};

	}

}


