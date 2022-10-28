package com.example.justificativo_microservice.Controllers;

import com.example.justificativo_microservice.Entities.JustificativoEntity;
import com.example.justificativo_microservice.Services.JustificativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("justificativo")
public class JustificativoController {
    @Autowired
    private JustificativoService justificativoService;

    @PostMapping(value = "/agregar")
    public ResponseEntity<JustificativoEntity> agregarJustificativo(@RequestBody JustificativoEntity justificativo){
        JustificativoEntity newJustificativo = justificativoService.addJustificativo(justificativo);
        return ResponseEntity.ok(newJustificativo);
    }
}