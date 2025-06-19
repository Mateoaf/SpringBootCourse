package com.example.reuniones.services;

import com.example.reuniones.data.PersonaRepository;
import com.example.reuniones.models.Persona;
import com.example.reuniones.models.Reunion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }
}
