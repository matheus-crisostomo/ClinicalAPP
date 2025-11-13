package br.com.clinical.clinicalApp.controllers;


import br.com.clinical.clinicalApp.models.Medico;
import br.com.clinical.clinicalApp.repositories.MedicoRepository;
import br.com.clinical.clinicalApp.services.MedicoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    private MedicoService service ;

    public List<Medico> listaMedicos() {
        return service.listarMedicos;
    }

}
