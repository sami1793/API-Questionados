package ar.com.ada.api.questionados.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Pregunta;

import ar.com.ada.api.questionados.services.PreguntaService;

@RestController
public class PreguntaController {
    
    @Autowired
    private PreguntaService service;

    @GetMapping("/preguntas")
    public ResponseEntity<List<Pregunta>> traerPreguntas(){//trae la lista de TODAS las preguntas        
        return ResponseEntity.ok(service.traerPreguntas());
    }

    @GetMapping("/preguntas/{id}")
    public ResponseEntity<Pregunta> traerPorPreguntaId(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarPregunta(id));
    }
}
