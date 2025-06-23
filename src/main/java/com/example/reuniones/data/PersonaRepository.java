package com.example.reuniones.data;


import com.example.reuniones.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "personas")
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
