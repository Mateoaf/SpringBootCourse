package com.example.reuniones.services;

import com.example.reuniones.models.Persona;
import com.example.reuniones.models.Reunion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    private static final List<Persona> personas = new ArrayList<>();

    static {
        for (int i = 0; i < 5; i++) {
            Persona persona = new Persona(i, "Nombre " + i, "Apellido " + i);
            personas.add(persona);
        }
    }

    public List<Persona> getAllPersonas() {
        return personas;
    }
}
