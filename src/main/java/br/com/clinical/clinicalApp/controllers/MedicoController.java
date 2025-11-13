package br.com.clinical.clinicalApp.controllers;


import br.com.clinical.clinicalApp.dto.RequestMedicoDTO;
import br.com.clinical.clinicalApp.dto.ResponseMedicoDTO;
import br.com.clinical.clinicalApp.services.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    private MedicoService service ;

    @GetMapping
    public List<ResponseMedicoDTO> listaMedicos() {
        return service.listaMedicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMedicoDTO> getMedicoById(@PathVariable(name = "id") Long id) {
        var medico = service.getMedicoById(id);
        return ResponseEntity.ok(medico);
    }

    @PostMapping
    public ResponseEntity<ResponseMedicoDTO> cadastrarMedico(@RequestBody RequestMedicoDTO medico){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrarMedico(medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarMedico(@PathVariable(name = "id") Long id) {
        service.deletarMedico(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
