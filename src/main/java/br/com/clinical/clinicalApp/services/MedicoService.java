package br.com.clinical.clinicalApp.services;


import br.com.clinical.clinicalApp.dto.ResponseMedicoDTO;
import br.com.clinical.clinicalApp.models.Medico;
import br.com.clinical.clinicalApp.repositories.MedicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public List<ResponseMedicoDTO> listaMedicos() {
        return medicoRepository.findAll().stream()
                .map();
    }

}
