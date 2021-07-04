package ar.com.ada.api.questionados.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.repos.PreguntaRepository;

@Service
public class PreguntaService {
    @Autowired
    PreguntaRepository repo;

    public List<Pregunta> traerPreguntas(){
        return repo.findAll();
    }

    public Pregunta buscarPregunta(Integer id) {
        Optional<Pregunta> resultado = repo.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        else return null;
    }
}
