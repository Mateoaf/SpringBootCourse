package com.example.reuniones.services;

import com.example.reuniones.data.ReunionRepository;
import com.example.reuniones.models.Persona;
import com.example.reuniones.models.Reunion;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReunionService {

    private final ReunionRepository reunionRepository;

    public ReunionService(ReunionRepository reunionRepository) {
        this.reunionRepository = reunionRepository;
    }

    public List<Reunion> getAllReuniones() {
        return reunionRepository.findAll();
    }
}
