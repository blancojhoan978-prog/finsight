package com.app.finsight.Controller;

import com.app.finsight.model.CategoriaUsuario;
import com.app.finsight.repository.CategoriaUsuarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin("*")
public class CategoriaUsuarioController {

    private final CategoriaUsuarioRepository repo;

    public CategoriaUsuarioController(CategoriaUsuarioRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<CategoriaUsuario> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaUsuario getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public CategoriaUsuario create(@RequestBody CategoriaUsuario categoria) {
        return repo.save(categoria);
    }

    @PutMapping("/{id}")
    public CategoriaUsuario update(@PathVariable Long id, @RequestBody CategoriaUsuario categoria) {
        categoria.setId(id);
        return repo.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
