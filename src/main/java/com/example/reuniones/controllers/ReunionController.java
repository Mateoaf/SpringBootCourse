package com.example.reuniones.controllers;

import com.example.reuniones.models.Persona;
import com.example.reuniones.models.Reunion;
import com.example.reuniones.services.ReunionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reuniones")
public class ReunionController {

    @Autowired
    private ReunionService reunionService;

    @GetMapping
    public String getAllReuniones (Model model) {
        model.addAttribute("reuniones", reunionService.getAllReuniones());
        return "reuniones";
    }
  /* @GetMapping
   public String getAllReuniones (Model model) {
       List<Reunion> reuniones = reunionService.getAllReuniones();
       // --- INICIO: Añade estas líneas para depuración ---
       System.out.println("DEBUG: ReunionController - Recuperadas " + reuniones.size() + " reuniones.");
       if (!reuniones.isEmpty()) {
           reuniones.forEach(r -> {
               System.out.println("DEBUG: ReunionController - Reunión: ID=" + r.getId() + ", Asunto=" + r.getAsunto() + ", Fecha=" + r.getFecha());
               if (r.getAsistentes() != null && !r.getAsistentes().isEmpty()) {
                   r.getAsistentes().forEach(a -> System.out.println("  Asistente: " + a.getNombre() + " " + a.getApellidos()));
               } else {
                   System.out.println("  Sin asistentes.");
               }
           });
       } else {
           System.out.println("DEBUG: ReunionController - La lista de reuniones está vacía.");
       }
       // --- FIN: Líneas de depuración ---
       model.addAttribute("reuniones", reuniones);
       return "reuniones";
   }*/
}
