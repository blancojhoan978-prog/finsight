package com.app.finsight.Controller;
import com.app.finsight.model.MetaAhorro;
import com.app.finsight.repository.MetaAhorroRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/metas")
@CrossOrigin("*")
public class MetaAhorroController {

    private final MetaAhorroRepository repo;

    public MetaAhorroController(MetaAhorroRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<MetaAhorro> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public MetaAhorro getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public MetaAhorro create(@RequestBody MetaAhorro meta) {
        return repo.save(meta);
    }

    @PutMapping("/{id}")
    public MetaAhorro update(@PathVariable Long id, @RequestBody MetaAhorro meta) {
        meta.setId(id);
        return repo.save(meta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
