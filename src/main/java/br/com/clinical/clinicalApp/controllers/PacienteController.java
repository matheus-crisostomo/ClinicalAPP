package br.com.clinical.clinicalApp.controllers;


import br.com.clinical.clinicalApp.dto.ResponsePacienteDTO;
import br.com.clinical.clinicalApp.services.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private PacienteService service;

    @GetMapping
    public List<ResponsePacienteDTO> listPacientes() {
        return service.listarPacientes();
    }



}
