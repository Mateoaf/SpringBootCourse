package com.example.reuniones.controllers;

import com.example.reuniones.models.Persona;
import com.example.reuniones.models.Reunion;
import com.example.reuniones.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;


    @GetMapping
    public String getAllPersonas (Model model) {
        model.addAttribute("personas", personaService.getAllPersonas());
        return "personas";
    }
 /* @GetMapping
  public String getAllPersonas (Model model) {
      List<Persona> personas = personaService.getAllPersonas();
      // --- INICIO: Añade estas líneas para depuración ---
      System.out.println("DEBUG: PersonaController - Recuperadas " + personas.size() + " personas.");
      if (!personas.isEmpty()) {
          personas.forEach(p -> System.out.println("DEBUG: PersonaController - Persona: ID=" + p.getId() + ", Nombre=" + p.getNombre() + " " + p.getApellidos()));
      } else {
          System.out.println("DEBUG: PersonaController - La lista de personas está vacía.");
      }
      // --- FIN: Líneas de depuración ---
      model.addAttribute("personas", personas);
      return "personas";
  }*/
}
