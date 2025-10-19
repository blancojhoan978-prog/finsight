package com.app.finsight.repository;

import com.app.finsight.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion,Long> {
}
