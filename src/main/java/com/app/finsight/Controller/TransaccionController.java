package com.app.finsight.Controller;

import com.app.finsight.model.Transaccion;
import com.app.finsight.repository.TransaccionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacciones")
@CrossOrigin("*")
public class TransaccionController {

    private final TransaccionRepository repo;

    public TransaccionController(TransaccionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<List<Transaccion>> getAll() {
        List<Transaccion> transacciones = repo.findAll();
        return ResponseEntity.ok(transacciones);
    }

    /**
     * Obtiene una transacción por su ID
     * @param id ID de la transacción a buscar
     * @return ResponseEntity con la transacción encontrada o 404 si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> getById(@PathVariable Long id) {
        Optional<Transaccion> transaccion = repo.findById(id);

        if (transaccion.isPresent()) {
            return ResponseEntity.ok(transaccion.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Transaccion> create(@RequestBody Transaccion transaccion) {
        Transaccion nuevaTransaccion = repo.save(transaccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTransaccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> update(@PathVariable Long id, @RequestBody Transaccion transaccion) {
        if (!repo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        transaccion.setId(id);
        Transaccion transaccionActualizada = repo.save(transaccion);
        return ResponseEntity.ok(transaccionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}