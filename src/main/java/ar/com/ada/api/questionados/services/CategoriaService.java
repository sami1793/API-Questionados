package ar.com.ada.api.questionados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.models.request.CategoriaModificada;
import ar.com.ada.api.questionados.repos.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    public boolean existeCategoriaId(Integer categoriaId){
        if ((buscarCategoria(categoriaId)!=null)){
            return true;
        }
        else return false;
    }

    public void crearCategoria(Categoria categoria) {
        repo.save(categoria);

    }

    public List<Categoria> traerCategorias() {
        return repo.findAll();
    }

    public Categoria buscarCategoria(Integer id) {
        Optional <Categoria> resultado = repo.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        else return null;    
    }

    public void eliminarCategoria(Integer id){
        Categoria categoria= buscarCategoria(id);
        repo.delete(categoria);
    }

    public void modificarCategoria(Integer id, CategoriaModificada categoriaModificada){
        Categoria categoria = buscarCategoria(id);

        categoria.setNombre(categoriaModificada.nombre);
        categoria.setDescripcion(categoriaModificada.descripcion);

        repo.save(categoria);
    }
    
}
