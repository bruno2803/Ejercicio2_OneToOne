package com.utn.ejerc02.repositorios;

import com.utn.ejerc02.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
