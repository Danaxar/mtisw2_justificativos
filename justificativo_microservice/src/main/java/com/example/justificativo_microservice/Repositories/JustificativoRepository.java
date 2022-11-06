package com.example.justificativo_microservice.Repositories;

import com.example.justificativo_microservice.Entities.JustificativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface JustificativoRepository extends JpaRepository<JustificativoEntity, Integer> {
    ArrayList<JustificativoEntity> findByFechaAndRut(String fecha, String rut);
}
