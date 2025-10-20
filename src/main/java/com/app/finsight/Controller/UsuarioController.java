package com.app.finsight.Controller;

import com.app.finsight.model.Usuario;
import com.app.finsight.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    private final UsuarioRepository repo;
    public UsuarioController(UsuarioRepository repo) {
        this.repo = repo;
    }
    @GetMapping
    public List<Usuario> getAll() {
        return repo.findAll();
    }
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return repo.save(usuario);
    }
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String contrasena = datos.get("contrasena");

        Optional<Usuario> usuarioOpt = repo.findByCorreoAndContrasena(correo, contrasena);

        Map<String, Object> respuesta = new HashMap<>();

        if (usuarioOpt.isPresent()) {
            respuesta.put("status", "success");
            respuesta.put("usuario", usuarioOpt.get());
        } else {
            respuesta.put("status", "error");
            respuesta.put("mensaje", "Correo o contraseña incorrectos");
        }

        return respuesta;
    }
}
