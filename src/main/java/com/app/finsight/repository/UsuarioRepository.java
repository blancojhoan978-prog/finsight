package com.app.finsight.repository;

import com.app.finsight.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);
    Optional<Usuario> findByCorreo(String correo);
}