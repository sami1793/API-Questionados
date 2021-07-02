package ar.com.ada.api.questionados.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.models.response.GenericResponse;
import ar.com.ada.api.questionados.services.CategoriaService;

@RestController
public class CategoriaController {
    
    @Autowired
    private CategoriaService service;

    @PostMapping("/categorias")//crea una categoria
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){

        GenericResponse respuesta = new GenericResponse();
        service.crearCategoria(categoria);

        respuesta.isOk=true;
        respuesta.message="Categoria creada con éxito";

        return ResponseEntity.ok(respuesta);

    } 
}
