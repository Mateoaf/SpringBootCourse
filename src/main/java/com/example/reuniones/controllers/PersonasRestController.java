package com.example.reuniones.controllers;

import com.example.reuniones.models.Persona;
import com.example.reuniones.services.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonasRestController {

    private PersonaService personaService;

    public PersonasRestController(PersonaService personaService) {
        this.personaService = personaService;
    }
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }
}
