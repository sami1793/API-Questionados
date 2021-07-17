package ar.com.ada.api.questionados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.models.request.CategoriaModificada;
import ar.com.ada.api.questionados.models.response.GenericResponse;
import ar.com.ada.api.questionados.services.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class CategoriaController {
    
    @Autowired
    private CategoriaService service;

    
    // GET Categorias
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> traerCategorias() {

        return ResponseEntity.ok(service.traerCategorias());
    }

    // GET Categoria por id
    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> traerCategoriaPorId(@PathVariable Integer id){

        return ResponseEntity.ok(service.buscarCategoria(id));
    }

    @PostMapping("/categorias")//crea una categoria
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){

        GenericResponse respuesta = new GenericResponse();

        if (!(service.existeCategoriaId(categoria.getCategoriaId()))){
            service.crearCategoria(categoria);

            respuesta.isOk=true;
            respuesta.message="Categoria creada con éxito";

            return ResponseEntity.ok(respuesta);

        }
        else {
            respuesta.isOk=false;
            respuesta.message="Ya existe una categoria con este Id";
            return ResponseEntity.badRequest().body(respuesta);
        }
        
    } 
    @DeleteMapping("/categorias/{id}")//elimina una categoria por id
    public ResponseEntity<GenericResponse> eliminarCategoria(@PathVariable Integer id){

        GenericResponse respuesta = new GenericResponse();

        if(service.existeCategoriaId(id)){
            service.eliminarCategoria(id);

            respuesta.isOk=true;
            respuesta.message="Categoría eliminada correctamente";

            return ResponseEntity.ok(respuesta);
        }
        else {
            respuesta.isOk=false;
            respuesta.message="No existe una categoria con este Id";
            return ResponseEntity.badRequest().body(respuesta);
        }
    }

    @PutMapping("/categorias/{id}")//modifica una categoria
    public ResponseEntity<GenericResponse> modificarCategoria(@PathVariable Integer id, @RequestBody CategoriaModificada categoriaModificada){

        GenericResponse respuesta= new GenericResponse();

        if(service.existeCategoriaId(id)){
            service.modificarCategoria(id, categoriaModificada);

            respuesta.isOk=true;
            respuesta.message="Categoria modificada con éxito";
            return ResponseEntity.ok(respuesta);
        }
        else {
            respuesta.isOk=false;
            respuesta.message="No existe una categoria con este Id";
            return ResponseEntity.badRequest().body(respuesta);
        }
    }
    
}
