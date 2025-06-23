package com.example.reuniones.services;

import com.example.reuniones.data.PersonaRepository;
import com.example.reuniones.models.Persona;
import com.example.reuniones.models.Reunion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }
    public Optional<Persona> getById(long id){
        return personaRepository.findById(id);
    }
}
