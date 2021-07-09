package ar.com.ada.api.questionados.models.response;

import java.util.*;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.entities.Respuesta;

public class PreguntaAResolver {

    public Integer pregunta_id;

    public Categoria categoria;

    public String enunciado;

    public List<OpcionPregunta> opciones = new ArrayList<>();


    public static PreguntaAResolver convertirDesde(Pregunta pregunta){//método de clase
        
        PreguntaAResolver preguntaAResolver= new PreguntaAResolver();
        
        preguntaAResolver.pregunta_id= pregunta.getPreguntaId();
        preguntaAResolver.categoria=pregunta.getCategoria();
        preguntaAResolver.enunciado=pregunta.getEnunciado();

        OpcionPregunta opcionPregunta = new OpcionPregunta();

        for (Respuesta respuesta : pregunta.getOpciones()) {
            opcionPregunta.respuestaId=respuesta.getRespuestaId();
            opcionPregunta.texto=respuesta.getTexto();
            
            preguntaAResolver.opciones.add(opcionPregunta);
            
        }

        return preguntaAResolver;
    }

}
