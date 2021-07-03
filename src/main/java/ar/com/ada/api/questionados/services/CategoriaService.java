package ar.com.ada.api.questionados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.repos.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

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
    
}
