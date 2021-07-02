package ar.com.ada.api.questionados.services;

import java.util.List;

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
    
}
