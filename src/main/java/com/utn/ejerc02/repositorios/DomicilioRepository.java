package com.utn.ejerc02.repositorios;

import com.utn.ejerc02.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
