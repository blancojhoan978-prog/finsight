package com.app.finsight.Controller;
import com.app.finsight.model.Presupuesto;
import com.app.finsight.repository.PresupuestoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/presupuestos")
@CrossOrigin("*")
public class PresupuestoController {

    private final PresupuestoRepository repo;

    public PresupuestoController(PresupuestoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Presupuesto> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Presupuesto getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Presupuesto create(@RequestBody Presupuesto presupuesto) {
        return repo.save(presupuesto);
    }

    @PutMapping("/{id}")
    public Presupuesto update(@PathVariable Long id, @RequestBody Presupuesto presupuesto) {
        presupuesto.setId(id);
        return repo.save(presupuesto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
