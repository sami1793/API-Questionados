package ar.com.ada.api.questionados.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.com.ada.api.questionados.entities.Pregunta;

@Service
public class QuestionadosService {

    @Autowired
    private PreguntaService preguntaService;

    public Pregunta traerPreguntaRandom() {

        List<Pregunta> todasLasPreguntas = preguntaService.traerPreguntas();
        
        int max = todasLasPreguntas.size();
        int random = (int)(Math.random()*max);//trae valores random del 0 al max,  sin incluir max 

        return todasLasPreguntas.get(random);
    
    }
    
    public Pregunta traerPreguntaRandomV2() {

        List<Pregunta> todasLasPreguntas = preguntaService.traerPreguntas();
        int min = 1;
        int max = todasLasPreguntas.size();
        int random = (int) (Math.random() * ((max - min) + 1)) + min;
        
        return todasLasPreguntas.get(random - 1);

    }
}
