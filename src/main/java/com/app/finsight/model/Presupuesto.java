package com.app.finsight.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "presupuestos")
public class Presupuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer mes;
    private Integer año;

    private String categoria;

    @Column(name = "limite_mensual")
    private BigDecimal limiteMensual;

    @Column(name = "gasto_actual")
    private BigDecimal gastoActual;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }

    public Integer getAño() { return año; }
    public void setAño(Integer año) { this.año = año; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public BigDecimal getLimiteMensual() { return limiteMensual; }
    public void setLimiteMensual(BigDecimal limiteMensual) { this.limiteMensual = limiteMensual; }

    public BigDecimal getGastoActual() { return gastoActual; }
    public void setGastoActual(BigDecimal gastoActual) { this.gastoActual = gastoActual; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
