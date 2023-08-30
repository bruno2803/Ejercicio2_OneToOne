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
					.nombre("Pedro")
					.apellido("Garcia")
					.edad(20)
					.build();

			Domicilio domicilio = Domicilio.builder()
					.calle("Las cañuelas")
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

			Persona persona1 = Persona.builder()
					.nombre("Victoria")
					.apellido("Redondo")
					.edad(34)
					.build();

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Bransen")
					.numero(435)
					.build();

			// Asocio el domicilio
			persona1.setDomicilio(domicilio1);

			// Guardar el objeto Persona en la base de datos

			personaRepository.save(persona1);

			// Recuperar el objeto Persona desde la base de datos
			Persona personaRecuperada1 = personaRepository.findById(persona1.getId()).orElse(null);
			if (personaRecuperada1 != null) {
				System.out.println("Nombre: " + personaRecuperada1.getNombre());
				System.out.println("Apellido: " + personaRecuperada1.getApellido());
				System.out.println("Edad: " + personaRecuperada1.getEdad());
				System.out.println("Calle : " + personaRecuperada1.getDomicilio().getCalle());
				System.out.println("Número :" + personaRecuperada1.getDomicilio().getNumero());
			}

			Persona persona2 = Persona.builder()
					.nombre("Roberto")
					.apellido("Silvestre")
					.edad(53)
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Av. Corrientes")
					.numero(1043)
					.build();

			// Asocio el domicilio
			persona2.setDomicilio(domicilio2);

			// Guardar el objeto Persona en la base de datos

			personaRepository.save(persona2);

			// Recuperar el objeto Persona desde la base de datos
			Persona personaRecuperada2 = personaRepository.findById(persona2.getId()).orElse(null);
			if (personaRecuperada2 != null) {
				System.out.println("Nombre: " + personaRecuperada2.getNombre());
				System.out.println("Apellido: " + personaRecuperada2.getApellido());
				System.out.println("Edad: " + personaRecuperada2.getEdad());
				System.out.println("Calle : " + personaRecuperada2.getDomicilio().getCalle());
				System.out.println("Número :" + personaRecuperada2.getDomicilio().getNumero());
			}

		};

	}

}


