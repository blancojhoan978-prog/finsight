package com.app.finsight.repository;

import com.app.finsight.model.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresupuestoRepository extends JpaRepository<Presupuesto,Long> {
}
