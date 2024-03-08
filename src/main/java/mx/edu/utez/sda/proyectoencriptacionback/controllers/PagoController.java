package mx.edu.utez.sda.proyectoencriptacionback.controllers;

import lombok.RequiredArgsConstructor;
import mx.edu.utez.sda.proyectoencriptacionback.models.Pago;
import mx.edu.utez.sda.proyectoencriptacionback.services.PagoService;
import mx.edu.utez.sda.proyectoencriptacionback.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ={"*"})
@RequestMapping("/api/pago")
@RequiredArgsConstructor
public class PagoController {
    @Autowired
    PagoService pagoService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<CustomReponse<List<Pago>>> getAll(){
        return ResponseEntity.ok(pagoService.getAll());
    }

    //Remplazar por DTO que tambien va a decifrar
    @PostMapping(value = "/save")
    public ResponseEntity<CustomReponse<Pago>> save(@RequestBody Pago pago){
        return ResponseEntity.ok(pagoService.save(pago));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CustomReponse<Pago>> update(@PathVariable long id, @RequestBody Pago pago){
        return ResponseEntity.ok(pagoService.update(id, pago));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<CustomReponse<Pago>> delete(@PathVariable long id){
        return ResponseEntity.ok(pagoService.delete(id));
    }


}
