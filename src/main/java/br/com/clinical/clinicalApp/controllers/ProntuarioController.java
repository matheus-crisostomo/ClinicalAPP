package br.com.clinical.clinicalApp.controllers;


import br.com.clinical.clinicalApp.dto.RequestProntuarioDTO;
import br.com.clinical.clinicalApp.dto.ResponseProntuarioDTO;
import br.com.clinical.clinicalApp.services.ProntuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuarios")
@AllArgsConstructor
public class ProntuarioController {

    private final ProntuarioService service;

    @GetMapping
    public List<ResponseProntuarioDTO> listar() {
        return service.listarProntuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProntuarioDTO> buscarProntuario(@PathVariable Long id) {
        var prontuario = service.getProntuarioById(id);
        return ResponseEntity.ok(prontuario);
    }

    @PostMapping
    public ResponseEntity<ResponseProntuarioDTO> criarProntuario(@RequestBody RequestProntuarioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarProntuario(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProntuario(@PathVariable Long id) {
        service.deleteProntuario(id);
        return ResponseEntity.noContent().build();
    }
}
