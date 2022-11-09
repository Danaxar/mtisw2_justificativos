package com.example.justificativo_microservice.Controllers;
import com.example.justificativo_microservice.Entities.JustificativoEntity;
import com.example.justificativo_microservice.Services.JustificativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/justificativo")
public class JustificativoController {
    @Autowired
    private JustificativoService justificativoService;

    @GetMapping("/listar")
    public ResponseEntity<ArrayList<JustificativoEntity>> getAll(){
        ArrayList<JustificativoEntity> justificativos = justificativoService.listAllJustificativo();
        if(justificativos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(justificativos);
    }

    @GetMapping("/get-by-rut-and-fecha/{rut}/{fecha}")
    public ResponseEntity<ArrayList<JustificativoEntity>> getByRutAndFecha(@PathVariable("rut") String rut, @PathVariable("fecha") String fecha){
        //System.out.println("Justificativo controller: getByRutAndFecha");
        ArrayList<JustificativoEntity> resp = justificativoService.getByRutAndFecha(justificativoService.reformatFecha(fecha), rut);
        if(resp.isEmpty()){
            //System.out.println("Justificativo controller: No se encuentran datos de justificativos.");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resp); // false
        
    }

    @PostMapping
    public ResponseEntity<JustificativoEntity> agregarJustificativo(@RequestBody JustificativoEntity justificativo){
        try {
            justificativoService.addJustificativo(justificativo);  // Lo guarda en la base de datos
            return ResponseEntity.ok(justificativo);
        } catch (Exception e){
            System.out.println("Error" +e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
