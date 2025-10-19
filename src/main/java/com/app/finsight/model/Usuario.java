
package com.app.finsight.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("usuario") // ← Evita serializar el usuario dentro de categorias
    private List<CategoriaUsuario> categorias;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("usuario") // ← Evita serializar el usuario dentro de transacciones
    private List<Transaccion> transacciones;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("usuario") // ← Evita serializar el usuario dentro de presupuestos
    private List<Presupuesto> presupuestos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("usuario") // ← Evita serializar el usuario dentro de metasAhorro
    private List<MetaAhorro> metasAhorro;

    @PrePersist
    public void prePersist() {
        if (fechaRegistro == null) {
            fechaRegistro = LocalDateTime.now();
        }
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public List<CategoriaUsuario> getCategorias() { return categorias; }
    public void setCategorias(List<CategoriaUsuario> categorias) { this.categorias = categorias; }

    public List<Transaccion> getTransacciones() { return transacciones; }
    public void setTransacciones(List<Transaccion> transacciones) { this.transacciones = transacciones; }

    public List<Presupuesto> getPresupuestos() { return presupuestos; }
    public void setPresupuestos(List<Presupuesto> presupuestos) { this.presupuestos = presupuestos; }

    public List<MetaAhorro> getMetasAhorro() { return metasAhorro; }
    public void setMetasAhorro(List<MetaAhorro> metasAhorro) { this.metasAhorro = metasAhorro; }
}
