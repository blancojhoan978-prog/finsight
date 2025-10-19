package com.app.finsight.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorias_usuario")
public class CategoriaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "ultima_uso")
    private LocalDateTime ultimaUso;

    @Column(name = "uso_count")
    private Integer usoCount;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"transacciones", "categorias", "presupuestos", "metasAhorro"})
    // ← CRÍTICO: Evita el ciclo infinito
    private Usuario usuario;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public LocalDateTime getUltimaUso() { return ultimaUso; }
    public void setUltimaUso(LocalDateTime ultimaUso) { this.ultimaUso = ultimaUso; }

    public Integer getUsoCount() { return usoCount; }
    public void setUsoCount(Integer usoCount) { this.usoCount = usoCount; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}