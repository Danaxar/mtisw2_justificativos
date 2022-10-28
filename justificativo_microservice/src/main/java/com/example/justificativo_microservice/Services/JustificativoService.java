package com.example.justificativo_microservice.Services;

import com.example.justificativo_microservice.Entities.JustificativoEntity;
import com.example.justificativo_microservice.Repositories.JustificativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JustificativoService{
    @Autowired
    JustificativoRepository justificativoRepository;

    public ArrayList<JustificativoEntity> listAllJustificativo(){
        return (ArrayList<JustificativoEntity>) justificativoRepository.findAll();
    }

    public JustificativoEntity addJustificativo(JustificativoEntity justificativo){
        return justificativoRepository.save(justificativo);
    }

    public boolean existeJustificativo(String fecha, String rut){
        ArrayList<JustificativoEntity> justificativo = justificativoRepository.findByFechaAndRut(fecha, rut);
        if(justificativo.size() == 1){
            return true;
        }else{
            return false;
        }
    }
}