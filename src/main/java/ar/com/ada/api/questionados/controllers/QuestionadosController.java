package ar.com.ada.api.questionados.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.entities.Respuesta;
import ar.com.ada.api.questionados.models.request.RespuestaAVerificar;
import ar.com.ada.api.questionados.models.response.OpcionPregunta;
import ar.com.ada.api.questionados.models.response.PreguntaAResolver;
import ar.com.ada.api.questionados.models.response.RespuestaVerificada;
import ar.com.ada.api.questionados.services.QuestionadosService;

@RestController
public class QuestionadosController {
    
    @Autowired
    private QuestionadosService service;

    @GetMapping("/questionados/next")//trae una pregunta aleatoria
    public ResponseEntity <PreguntaAResolver> traerPreguntaRandom(){
        Pregunta pregunta = new Pregunta();
        pregunta=service.traerPreguntaRandom();

        PreguntaAResolver preguntaAResolver= PreguntaAResolver.convertirDesde(pregunta);

        return ResponseEntity.ok(preguntaAResolver);
    }

    @PostMapping("/questionados/verificaciones")
    public ResponseEntity <RespuestaVerificada> preguntaAVerificar(@RequestBody RespuestaAVerificar respuesta){
        RespuestaVerificada respuestaVerficada= new RespuestaVerificada();
        
        respuestaVerficada.esCorrecta = service.esRespuestaCorrecta(respuesta.preguntaId,respuesta.respuestaId);

        return ResponseEntity.ok(respuestaVerficada);
        
    } 

    
    
}
