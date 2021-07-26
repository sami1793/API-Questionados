package ar.com.ada.api.questionados.entities;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="pregunta")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pregunta_id")
    private Integer preguntaId;

    @ManyToOne
    //preguntar al profe si se debe agregar @Column "categoria_id"
    @JoinColumn(name="categoria_id", referencedColumnName = "categoria_id")
    private Categoria categoria;

    private String enunciado;

    //CON EAGER ME REPITE LAS PREGUNTAS EN  preguntas por categoria, CON ObtenerPreguntasPorCategoriaV2 si sirve EAGER
    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)//Pregunta pregunta en clase Respuesta
    private List<Respuesta> opciones = new ArrayList<>();



    public Integer getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        this.categoria.agregarPregunta(this);//relacion bidireccional
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Respuesta> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Respuesta> opciones) {
        this.opciones = opciones;
    }

    //para relacion bidireccional
    public void agregarRespuesta(Respuesta respuesta){
        this.opciones.add(respuesta);
    }


    
    
}
