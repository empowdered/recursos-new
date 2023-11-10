package com.recursos.gestion.repository;

import com.recursos.gestion.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    public static final long serialVersionUID = 1L;

}
