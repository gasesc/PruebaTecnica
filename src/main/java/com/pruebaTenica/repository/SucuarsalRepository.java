package com.pruebaTenica.repository;

import com.pruebaTenica.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucuarsalRepository extends JpaRepository<Sucursal,Long> {
}
