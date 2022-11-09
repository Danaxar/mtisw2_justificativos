package com.example.justificativo_microservice.Repositories;

import com.example.justificativo_microservice.Entities.JustificativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface JustificativoRepository extends JpaRepository<JustificativoEntity, Integer> {
    @Query(value = "select * from data as e where e.rut = :rut and e.fecha = :fecha", nativeQuery = true)
    ArrayList<JustificativoEntity> findJustificativoEntitiesByRutAndFecha(@Param("rut") String rut, @Param("fecha") String fecha);
    
    ArrayList<JustificativoEntity> findByFechaAndRut(String fecha, String rut);
}
