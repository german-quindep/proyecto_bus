package com.example.backend_boleteria.CompraAsientos.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backend_boleteria.CompraAsientos.DTO.in.ConsultAsiento;
import com.example.backend_boleteria.CompraAsientos.Entity.CompraAsientoEntity;
import com.example.backend_boleteria.CompraAsientos.Query.QueryCompraAsiento;

public interface ComprarAsientosRepository extends JpaRepository<CompraAsientoEntity, UUID> {
    @Query(value = QueryCompraAsiento.GET_ASIENTOS_DISPONIBLE, nativeQuery = true)
    List<CompraAsientoEntity> getAllAsientosDisponible(@Param("consult") ConsultAsiento consult);

}
