package com.example.reuniones.async;

import com.example.reuniones.models.Persona;
import com.example.reuniones.models.Reunion;
import com.example.reuniones.services.PersonaService;
import com.example.reuniones.services.ReunionService;
import com.example.reuniones.tasks.DirectorioRunner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscaListener {

    private static final Logger LOG = LoggerFactory.getLogger(BuscaListener.class);

    private final ObjectMapper mapper;
    private final PersonaService personaService;
    private final ReunionService reunionService;

    public BuscaListener(ObjectMapper mapper, PersonaService personaService, ReunionService reunionService) {
        this.mapper = mapper;
        this.personaService = personaService;
        this.reunionService = reunionService;
    }

    public void recibirMensaje(String mensaje){
        try {
            InfoBusca info = mapper.readValue(mensaje, InfoBusca.class);
            Optional<Persona> persona = personaService.getById(info.getIdAsistente());
            if (persona.isEmpty()) {
                LOG.warn("Mensaje recibido, pero la persona {} no existe",
                        info.getIdAsistente());
            }
            Optional<Reunion> reunion = reunionService.getById(info.getIdReunion());
            if (reunion.isEmpty()) {
                LOG.warn("Mensaje recibido, pero la reunión {} no existe",
                        info.getIdReunion());
            }
            if (persona.isPresent() && reunion.isPresent()) {
                LOG.info("{} {} tiene una reunión a las {}",
                        persona.get().getNombre(),
                        persona.get().getApellidos(),
                        reunion.get().getFecha());
            }

        } catch (JsonProcessingException e){
            LOG.warn("Mensaje incorrrecto", e);
        }
    }
}
