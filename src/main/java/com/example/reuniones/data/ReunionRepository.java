package com.example.reuniones.data;

import com.example.reuniones.models.Persona;
import com.example.reuniones.models.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReunionRepository extends JpaRepository<Reunion, Long> {
}
