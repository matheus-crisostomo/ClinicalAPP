package br.com.clinical.clinicalApp.controllers;


import br.com.clinical.clinicalApp.dto.RequestConsultaDTO;
import br.com.clinical.clinicalApp.dto.ResponseConsultaDTO;
import br.com.clinical.clinicalApp.dto.UpdateConsultaDTO;
import br.com.clinical.clinicalApp.services.ConsultaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consultas")
public class ConsultaController {
    private ConsultaService service;

    @GetMapping
    public List<ResponseConsultaDTO> consultas() {
        return service.listarConsultas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseConsultaDTO> consulta(@PathVariable Long id) {
        var consulta = service.getConsultabyId(id);
        return ResponseEntity.ok(consulta);
    }

    @PostMapping
    public ResponseEntity<ResponseConsultaDTO> cadastrarConsulta(RequestConsultaDTO consulta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarConsulta(consulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarConsulta(@PathVariable Long id) {
        service.removerConsulta(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseConsultaDTO> atualizarConsulta(@PathVariable Long id,
                                                                 @RequestBody UpdateConsultaDTO dto) {
        var consultaAtualizada = service.atualizarConsulta(id,dto);
        return ResponseEntity.ok(consultaAtualizada);
    }
}
