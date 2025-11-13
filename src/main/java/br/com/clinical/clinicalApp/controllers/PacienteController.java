package br.com.clinical.clinicalApp.controllers;


import br.com.clinical.clinicalApp.dto.RequestPacienteDTO;
import br.com.clinical.clinicalApp.dto.ResponsePacienteDTO;
import br.com.clinical.clinicalApp.services.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private PacienteService service;

    @GetMapping
    public List<ResponsePacienteDTO> listarPacientes() {
        return service.listarPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePacienteDTO> buscarPaciente(@PathVariable Long id) {
        var paciente = service.getPacienteByID(id);
        return ResponseEntity.ok(paciente);
    }

    @PostMapping
    public ResponseEntity<ResponsePacienteDTO> cadastrarPaciente(@RequestBody RequestPacienteDTO paciente) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvarPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPaciente(@PathVariable Long id) {
        service.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }




}
