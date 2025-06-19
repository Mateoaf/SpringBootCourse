package com.example.reuniones.services;

import com.example.reuniones.models.Persona;
import com.example.reuniones.models.Reunion;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReunionService {
    private static final List<Reunion> reuniones = new ArrayList<>();

    static {
        for (int i = 0; i < 5; i++) {
            Reunion reunion = new Reunion(i, "Reunion " + i, ZonedDateTime.now().plusDays(i));
            for(int j=0; j < i; j++){
                reunion.addAsistentes(
                        new Persona(i, "Nombre " + i, "Apellido " + j));
            }
            reuniones.add(reunion);
        }
    }

    public List<Reunion> getAllReuniones() {
        return reuniones;
    }
}
