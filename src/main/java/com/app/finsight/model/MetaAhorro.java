package com.app.finsight.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "metas_ahorro")
public class MetaAhorro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String estado;
    private String icono;

    private Integer cuotas;

    @Column(name = "monto_meta")
    private BigDecimal montoMeta;

    @Column(name = "monto_actual")
    private BigDecimal montoActual;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_recordatorio")
    private LocalDate fechaRecordatorio;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getIcono() { return icono; }
    public void setIcono(String icono) { this.icono = icono; }

    public Integer getCuotas() { return cuotas; }
    public void setCuotas(Integer cuotas) { this.cuotas = cuotas; }

    public BigDecimal getMontoMeta() { return montoMeta; }
    public void setMontoMeta(BigDecimal montoMeta) { this.montoMeta = montoMeta; }

    public BigDecimal getMontoActual() { return montoActual; }
    public void setMontoActual(BigDecimal montoActual) { this.montoActual = montoActual; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public LocalDate getFechaRecordatorio() { return fechaRecordatorio; }
    public void setFechaRecordatorio(LocalDate fechaRecordatorio) { this.fechaRecordatorio = fechaRecordatorio; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
