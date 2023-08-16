package com.example.backend_boleteria.Buses.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backend_boleteria.Buses.Entity.BusEntity;
import com.example.backend_boleteria.Buses.Query.BusQuery;

public interface BusRepository extends JpaRepository<BusEntity, UUID> {
    @Query(value = BusQuery.DELETE_BUS, nativeQuery = true)
    public void deleteByIdBus(@Param("id_bus") String id_bus);
}
